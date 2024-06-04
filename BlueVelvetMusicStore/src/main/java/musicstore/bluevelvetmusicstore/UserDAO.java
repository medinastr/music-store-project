package musicstore.bluevelvetmusicstore;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public void createProduct(Product product) {
        String sql = "INSERT INTO PRODUCTS (productName, description, brand, category, listPrice, cost) " +
                "VALUES " + product.productDetails();

        PreparedStatement ps = null;
        try {
            ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getCategory());
            ps.setDouble(5, product.getListPrice());
            ps.setDouble(6, product.getCost());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
