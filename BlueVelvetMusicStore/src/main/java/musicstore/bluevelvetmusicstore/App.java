package musicstore.bluevelvetmusicstore;

import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) throws Exception {
        Product product = new Product("Guitar", "You can play many guitar songs",
                "Rozini", "Instrument", 1200.00, 1399.90);

        UserDAO user = new UserDAO();
        user.createProduct(product);
    }
}
