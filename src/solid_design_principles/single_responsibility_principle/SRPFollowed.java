package solid_design_principles.single_responsibility_principle;

import java.util.ArrayList;
import java.util.List;

public class SRPFollowed {

    static class Product {
        public String name;
        public double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " - Rs " + price;
        }
    }

    static class ShoppingCart {
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product p) {
            products.add(p);
        }

        public List<Product> getProducts() {
            return this.products;
        }

        public double calculateTotal() {
            double total = 0;
            for (Product p : products) {
                total += p.price;
            }
            return total;
        }
    }

    static class ShoppingCartInvoicePrinter {
        private ShoppingCart cart;

        ShoppingCartInvoicePrinter(ShoppingCart cart) {
            this.cart = cart;
        }

        public void printInvoice() {
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

        public void saveToDatabase() {
            List<Product> products = cart.getProducts();
            System.out.println(products.toString());
            System.out.println("Saving shopping cart to database...");
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        ShoppingCartInvoicePrinter printer = new ShoppingCartInvoicePrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
