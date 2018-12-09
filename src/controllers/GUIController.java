package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Inventory;
import models.Product;
import models.PsudeauDB;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, String> descColumn;

    @FXML private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // load all products into the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("desc"));

        popTable();

        // load the categories into the choiceBox
        choiceBox.getItems().addAll(Inventory.getCategories());

    }

    public void popTable()
    {
        table.getItems().addAll(Inventory.getAllProducts());
    }

    public void reloadTable()
    {
        table.getItems().clear();
        popTable();
    }

    public void sellButtonPressed(ActionEvent actionEvent)
    {
        table.getSelectionModel().getSelectedItem().sellStock();
        reloadTable();
    }
}
