package solid_design_principles.open_close_principle;

import java.util.ArrayList;
import java.util.List;

public class OCPViolated {
    
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

    static class ShoppingCartStorage {
        private ShoppingCart cart; 

        ShoppingCartStorage(ShoppingCart cart) { 
            this.cart = cart; 
        }

        void saveToSQLDatabase() {
            System.out.println("Saving shopping cart to SQL DB...");
        }

        void saveToMongoDatabase() {
            System.out.println("Saving shopping cart to Mongo DB...");
        }

        void saveToFile() {
            System.out.println("Saving shopping cart to File...");
        }
    }


    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToSQLDatabase();
        db.saveToMongoDatabase();
        db.saveToFile();
    }

}
