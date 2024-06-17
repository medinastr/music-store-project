package musicstore.bluevelvetmusicstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.concurrent.ExecutionException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("My JavaFX Application");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);

//        Product product = new Product("Guitar Model X", "An excellent eletric guitar for begginers",
//                "Fender", "Instrument", 999.90, 550.00);
//
//        UserDAO user = new UserDAO();
//        user.createProduct(product);
//        user.deleteProduct("Acoustic Guitar");
    }
}