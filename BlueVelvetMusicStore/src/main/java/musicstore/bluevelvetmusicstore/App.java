package musicstore.bluevelvetmusicstore;

import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) throws Exception {
        Product product = new Product(" Microphone", "Professional condenser microphone",
                "Shure", "Accessory", 200.00, 150.00);

        UserDAO user = new UserDAO();
        user.createProduct(product);
        user.deleteProduct("Acoustic Guitar");
    }
}