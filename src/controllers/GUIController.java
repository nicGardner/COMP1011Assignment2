package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Inventory;
import models.Product;
import models.PsudeauDB;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> nameColumn;
    @FXML private TableColumn<Product, String> descColumn;

    @FXML private ChoiceBox<String> choiceBox;

    @FXML private Button resetSortButton;
    @FXML private Button sellButton;

    final ToggleGroup sortGroup = new ToggleGroup();
    @FXML private RadioButton highLow = new RadioButton();
    @FXML private RadioButton lowHigh;
    @FXML private RadioButton aZ;
    @FXML private RadioButton zA;

    private int optionPressed = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // put all the radio buttons in the same toggle group
        highLow.setToggleGroup(sortGroup);
        lowHigh.setToggleGroup(sortGroup);
        aZ.setToggleGroup(sortGroup);
        zA.setToggleGroup(sortGroup);

        // load all products into the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("desc"));

        popTable();

        // load the categories into the choiceBox
        choiceBox.getItems().addAll(Inventory.getCategories());

    }

    public void popTable()
    {
        ArrayList<Product> list = new ArrayList<>();
        list.addAll(Inventory.getAllProducts());
        // if one of the buttons was pressed
        if (optionPressed >= 1 && optionPressed <= 4)
        {
            Collections.sort(list);
        }
        System.out.println(list);
        table.getItems().addAll(list);
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

    public void highLowPressed(ActionEvent actionEvent) {
        optionPressed = 1;
        Product.setSortBy(1);
        reloadTable();
    }

    public void lowHighPressed(ActionEvent actionEvent) {
        optionPressed = 2;
        Product.setSortBy(2);
        reloadTable();
    }

    public void aZPressed(ActionEvent actionEvent) {
        optionPressed = 3;
        Product.setSortBy(3);
        reloadTable();
    }

    public void zAPressed(ActionEvent actionEvent) {
        optionPressed = 4;
        Product.setSortBy(4);
        reloadTable();
    }

    public void resetSortButtonPressed(ActionEvent actionEvent) {
        optionPressed = 0;
        Product.setSortBy(0);
        reloadTable();
        highLow.setSelected(false);
        lowHigh.setSelected(false);
        aZ.setSelected(false);
        zA.setSelected(false);
    }
}
