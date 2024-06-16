package musicstore.bluevelvetmusicstore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {
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
    private TableView<?> tablesviewBooks;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    @FXML
    public void initialize() {
        // Adicione a lógica de inicialização aqui
    }

    @FXML
    private void handleInsert() {
        // Adicione a lógica para o botão Inserir
    }

    @FXML
    private void handleUpdate() {
        // Adicione a lógica para o botão Atualizar
    }

    @FXML
    private void handleDelete() {
        // Adicione a lógica para o botão Excluir
    }
}
