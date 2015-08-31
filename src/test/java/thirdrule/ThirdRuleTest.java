package thirdrule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import firstrule.Person;
import secondrule.OrderProcessor;

public class ThirdRuleTest {

	private static AbstractApplicationContext ctx;
	private StatelessKnowledgeSession session;
	

	@BeforeClass
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
		session = ctx.getBean("thirdRuleSession", StatelessKnowledgeSession.class);
	}

	@After
	public void tearDown() throws Exception {
		session = null;
	}


	@Test
	public void testBasicDT_isRobb() {	
		Person robb = new Person("Robb");
		session.execute(robb);
	}

	@Test
	public void testBasicDT_isJohn() {	
		Person john = new Person("John");
		session.execute(john);
	}

	
	@Test
	public void testBasicDT_isJim() {	
		Person jim = new Person("Jim");
		session.execute(jim);
	}
}
