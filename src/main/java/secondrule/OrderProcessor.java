package secondrule;

import org.drools.runtime.StatelessKnowledgeSession;

/**
 * Demonstrate Drools rules engine when an order is being processed. Wired up
 * with Spring IoC to inject the Drools session.
 * 
 * @author ranichol
 *
 */
public class OrderProcessor {

	private StatelessKnowledgeSession rulesSession;
	
	private Order order;

	public OrderProcessor(StatelessKnowledgeSession rulesSession) {
		super();
		this.rulesSession = rulesSession;
	}

	public OrderProcessor createOrder(String description) {
		order = new Order(description);
		rulesSession.execute(order);
		return this;
	}
	
	public OrderProcessor addItemToOrder(Item item) {
		order.addItem(item);
		rulesSession.execute(order);
		return this;
	}

	public OrderProcessor removeItemFromOrder(Item item) {
		order.removeItem(item);
		rulesSession.execute(order);
		return this;
	}
	
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

}
