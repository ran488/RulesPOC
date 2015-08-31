package firstrule;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import firstrule.Person;

public class FirstRuleTest {

	KnowledgeBuilder kBldr;
	KnowledgeBase kBase;

	@Before
	public void setUp() throws Exception {

		kBldr = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kBldr.add(
				ResourceFactory.newClassPathResource("first_rules.drl", getClass()),
				ResourceType.DRL);
		if (kBldr.hasErrors()) {
			System.out.println("Error:" + kBldr.getErrors().toString());
			throw new Exception("Drools rules file has errors: " + kBldr.getErrors().toString());
		}

		kBase = KnowledgeBaseFactory.newKnowledgeBase();
		kBase.addKnowledgePackages(kBldr.getKnowledgePackages());
	}

	@After
	public void tearDown() throws Exception {
		kBldr = null;
		kBase = null;
	}

	@Test
	public void testRobbRule() {
		StatelessKnowledgeSession session = kBase.newStatelessKnowledgeSession();
		List<Person> peeps = new ArrayList<>();
		Person robb = new Person("robb");
		peeps.add(robb);
		Person notRobb = new Person("notRobb");
		peeps.add(notRobb);
		
		
		assertEquals("robb", robb.getName());
		assertEquals("notRobb", notRobb.getName());
		session.execute(peeps);
		assertEquals("ROBB", robb.getName());
		assertEquals("notRobb", notRobb.getName());
		
		
	}
}
