package musicstore.bluevelvetmusicstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public void createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO PRODUCTS (productName, description, brand, category, listPrice, cost) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getCategory());
            ps.setDouble(5, product.getListPrice());
            ps.setDouble(6, product.getCost());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product added successfully to the database.");
            } else {
                System.out.println("Failed to add the product to the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deleteProduct(String productName) throws SQLException {
        String sql = "DELETE FROM PRODUCTS WHERE productName = ?";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, productName);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the given name.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void updateProduct(String productName, String description, String brand, String category,
                              double listPrice, double cost) throws SQLException {
        String sql = "UPDATE PRODUCTS SET productName = ?, description = ?, brand = ?, category = ?, " +
                "listPrice = ?, cost = ? WHERE productName = ?";

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setString(2, description);
            ps.setString(3, brand);
            ps.setString(4, category);
            ps.setDouble(5, listPrice);
            ps.setDouble(6, cost);
            ps.setString(7, productName);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with the given name.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
