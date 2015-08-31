package secondrule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SecondRuleTest {

	private static AbstractApplicationContext ctx;
	OrderProcessor op;

	@BeforeClass
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		op = ctx.getBean("orderProcessor", OrderProcessor.class);
	}

	@After
	public void tearDown() throws Exception {
		op = null;
	}

	@Test
	public void testGetNewOrder_TotalsShouldBeZero() {
		OrderProcessor o = op.createOrder("unit test order");
		assertNotNull(o.getOrder());
		assertEquals(Double.valueOf(0.0), o.getOrder().getSalesTax());
		assertEquals(Double.valueOf(0.0), o.getOrder().getSubTotal());
		System.out.println(o.getOrder().toString());
	}

	@Test
	public void testAddToOrder() {
		OrderProcessor o = op.createOrder("unit test order").addItemToOrder(
				new Item("first item on order", 39.99));
		assertNotNull(o.getOrder());
		assertEquals(1, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(39.99), o.getOrder().getSubTotal());
		System.out.println(o.getOrder().toString());
	}

	@Test
	public void testAddToOrder_TwoItems() {
		OrderProcessor o = op.createOrder("unit test order")
				.addItemToOrder(new Item("first item on order", 39.99))
				.addItemToOrder(new Item("second", 19.99));
		assertNotNull(o.getOrder());
		assertEquals(2, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(59.98), o.getOrder().getSubTotal(), 0.001);
		System.out.println(o.getOrder().toString());
	}

	@Test
	public void testAddToOrder_AddTwoItemsRemoveOneItem() {
		Item i1 = new Item("first item on order", 39.99);
		Item i2 = new Item("second item", 19.99);
		OrderProcessor o = op.createOrder("unit test order").addItemToOrder(i1)
				.addItemToOrder(i2);
		assertEquals(2, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(59.98), o.getOrder().getSubTotal(), 0.001);
		o.removeItemFromOrder(i1);
		assertEquals(1, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(19.99), o.getOrder().getSubTotal(), 0.001);
		System.out.println(o.getOrder().toString());
	}

	@Test
	public void testAddToOrder_RemoveAllItems() {
		Item i1 = new Item("first item on order", 39.99);
		Item i2 = new Item("second item", 19.99);
		OrderProcessor o = op.createOrder("unit test order").addItemToOrder(i1)
				.addItemToOrder(i2);
		assertEquals(2, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(59.98), o.getOrder().getSubTotal(), 0.001);
		o.removeItemFromOrder(i1);
		o.removeItemFromOrder(i2);
		assertEquals(0, o.getOrder().getItems().size());
		assertEquals(Double.valueOf(0.0), o.getOrder().getSubTotal(), 0.001);
		System.out.println(o.getOrder().toString());
	}

}
