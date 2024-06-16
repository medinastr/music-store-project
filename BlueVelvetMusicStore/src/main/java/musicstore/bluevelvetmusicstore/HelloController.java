package musicstore.bluevelvetmusicstore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Label connectionStatusLabel;

    @FXML
    protected void testConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                connectionStatusLabel.setText("Connection to database established successfully.");
            } else {
                connectionStatusLabel.setText("Failed to establish connection to the database.");
            }
        } catch (SQLException e) {
            connectionStatusLabel.setText("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
