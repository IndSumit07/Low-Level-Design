package solid_design_principles.liskov_substitution_principle.lsp_rules.signature_rules;

// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides


public class MethodArgumentRule {

    static class Parent {
        public void print(String msg) {
            System.out.println("Parent: " + msg);
        }
    }

    static class Child extends Parent {
        @Override
        public void print(String msg) {
            System.out.println("Child: " + msg);
        }
    }

    // Client that passes a String msg as the client expects.
    static class Client {
        private Parent p;

        public Client(Parent p) {
            this.p = p;
        }

        public void printMsg() {
            p.print("Hello");
        }
    }
    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child  = new Child();

        Client client1 = new Client(parent);
        Client client2 = new Client(child);

        client1.printMsg();
        client2.printMsg();
    }
}
