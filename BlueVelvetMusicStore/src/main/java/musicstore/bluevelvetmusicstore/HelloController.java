package musicstore.bluevelvetmusicstore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController implements Initializable {
    private Label label;
    @FXML
    private TextField tfproductName;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfbrand;
    @FXML
    private TextField tfcategory;
    @FXML
    private TextField tflistPrice;
    @FXML
    private TextField tfcost;
    @FXML
    private TableView<Product> tvProducts;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableColumn<Product, String> colName;
    @FXML
    private TableColumn<Product, String> colDescription;
    @FXML
    private TableColumn<Product, String> colBrand;
    @FXML
    private TableColumn<Product, String> colCategory;
    @FXML
    private TableColumn<Product, Double> colListPrice;
    @FXML
    private TableColumn<Product, Double> colCost;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProducts();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        if(event.getSource() == btnInsert) {
            createButton();
        } else if (event.getSource() == btnDelete) {
            deleteButton();
        } else if(event.getSource() == btnUpdate) {
            updateButton();
        }
    }

    @FXML
    private void createButton() throws SQLException {
        double listPrice = Double.parseDouble(tflistPrice.getText());
        double cost = Double.parseDouble(tfcost.getText());
        Product product = new Product(tfproductName.getText(), tfdescription.getText(),
                tfbrand.getText(), tfcategory.getText(), listPrice, cost);

        UserDAO user = new UserDAO();
        user.createProduct(product);
        showProducts(); // update the table for the new item on database
    }

    @FXML
    private void updateButton() throws SQLException {
        double listPrice = Double.parseDouble(tflistPrice.getText());
        double cost = Double.parseDouble(tfcost.getText());

        UserDAO user = new UserDAO();
        user.updateProduct(tfproductName.getText(), tfdescription.getText(), tfbrand.getText(),
                tfcategory.getText(), listPrice, cost);
        showProducts();
    }

    @FXML
    private void deleteButton() throws SQLException {
        String temp = tfproductName.getText();

        UserDAO user = new UserDAO();
        user.deleteProduct(temp);
        showProducts();
    }

    public ObservableList<Product> getProductsList() {
        ObservableList<Product> productsList = FXCollections.observableArrayList();
        String str = "SELECT * FROM PRODUCTS";
        Statement st;
        ResultSet rs;
        Connection connection = DatabaseConnection.getConnection();

        try {
            st = connection.createStatement();
            rs = st.executeQuery(str);
            Product product;
            while(rs.next()) {
                product = new Product(rs.getString("productName"), rs.getString("description"), rs.getString("brand"),
                        rs.getString("category"), rs.getDouble("listPrice"), rs.getDouble("cost"));
                productsList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productsList;
    }

    public void showProducts() {
        ObservableList<Product> productsList = getProductsList();

        colName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        colBrand.setCellValueFactory(new PropertyValueFactory<Product, String>("brand"));
        colCategory.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        colListPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("listPrice"));
        colCost.setCellValueFactory(new PropertyValueFactory<Product, Double>("cost"));

        tvProducts.setItems(productsList);
    }
}
