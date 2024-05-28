package musicstore.bluevelvetmusicstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bluevelvet_db";
    private static final String USER = "florentino";
    private static final String PASSWORD = "Trabalho_2024@";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
