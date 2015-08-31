Basic Proof-of-concept using the JBoss/Red Hat Drools Rules Engine (Java)

Building:
- Use the Gradle wrapper to create the Eclipse project metadata and to run builds: 
  > gradlew eclipse
  > gradlew build

What's in here:
- Mostly the rules are demonstrated from a series of JUnit tests. They can be executed from your IDE or from command line using Gradle (or Gradle wrapper).

firstrule:
- A very simple rule run against a "Person" object. If the name matches mine, it will change the name to all upper case. The Drools knowledge base and session is created programmatically right in the JUnit test.

secondrule:
- A more complex set of rules that will fire when orders are created, when items are added or removed from an order, etc. The config is done through a Spring context instead of in the code. 
 
 thirdrule:
 - Demonstrate defining rules in a decision table (spreadsheet).