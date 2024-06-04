package musicstore.bluevelvetmusicstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateProduct extends Product {

    public CreateProduct(String productName, String description, String brand, String category, double listPrice, double cost) {
        super(productName, description, brand, category, listPrice, cost);
    }

    public void addProduct(Product product) throws SQLException {
        // Obtém a conexão com o banco de dados
        Connection connection = DatabaseConnection.getConnection();

        // Declaração SQL para inserir um novo produto na tabela do banco de dados
        String sql = "INSERT INTO PRODUCTS (productName, description, brand, category, listPrice, cost) " +
                "VALUES " + product.productDetails();

        // Prepara a declaração SQL para inserção
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Define os parâmetros da declaração SQL com base nas informações do produto
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getDescription());
            statement.setString(3, product.getBrand());
            statement.setString(4, product.getCategory());
            statement.setDouble(5, product.getListPrice());
            statement.setDouble(6, product.getCost());

            // Executa a declaração SQL para inserir o produto no banco de dados
            int rowsAffected = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (rowsAffected > 0) {
                System.out.println("Produto adicionado com sucesso ao banco de dados.");
            } else {
                System.out.println("Falha ao adicionar o produto ao banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o produto ao banco de dados: " + e.getMessage());
        } finally {
            // Fecha a conexão com o banco de dados
            if (connection != null) {
                connection.close();
            }
        }
    }
}
