package solid_design_principles.open_close_principle;

import java.util.ArrayList;
import java.util.List;

public class OCPFollowed {

    static class Product{

        String name;

        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class ShoppingCart {
        private List<Product> products = new ArrayList<>();

        void addProduct(Product p) { 
            products.add(p);
        }

        List<Product> getProducts() { 
            return products; 
        }

        double calculateTotal() {
            double total = 0;
            for (Product p : products) {
                total += p.price;
            }
            return total;
        }
    }

    static class ShoppingCartPrinter {
        private ShoppingCart cart; 

        ShoppingCartPrinter(ShoppingCart cart) { 
            this.cart = cart; 
        }

        void printInvoice() {
            System.out.println("Shopping Cart Invoice:");
            for (Product p : cart.getProducts()) {
                System.out.println(p.name + " - Rs " + p.price);
            }
            System.out.println("Total: Rs " + cart.calculateTotal());
        }
    }

    interface Persistence {
        void save(ShoppingCart cart);
    }

    static class SQLPersistence implements Persistence {
        @Override
        public void save(ShoppingCart cart) {
            System.out.println("Saving shopping cart to SQL DB...");
        }
    }

    static class MongoPersistence implements Persistence {
        @Override
        public void save(ShoppingCart cart) {
            System.out.println("Saving shopping cart to MongoDB...");
        }
    }

    static class FilePersistence implements Persistence {
        @Override
        public void save(ShoppingCart cart) {
            System.out.println("Saving shopping cart to a file...");
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        Persistence db    = new SQLPersistence();
        Persistence mongo = new MongoPersistence();
        Persistence file  = new FilePersistence();

        db.save(cart);    // Save to SQL database
        mongo.save(cart); // Save to MongoDB
        file.save(cart);  // Save to File
    }
}
