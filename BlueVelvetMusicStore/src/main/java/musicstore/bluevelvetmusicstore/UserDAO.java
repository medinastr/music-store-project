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
                System.out.println("Produto adicionado com sucesso ao banco de dados.");
            } else {
                System.out.println("Falha ao adicionar o produto ao banco de dados.");
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
