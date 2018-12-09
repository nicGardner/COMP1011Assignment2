package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.Inventory;
import models.Product;
import models.PsudeauDB;

import javafx.scene.image.ImageView;
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

    @FXML private ImageView imgView;

    @FXML private Text inventoryValue;
    @FXML private Text categoryValue;



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

        // create a listener so the user can select an entry in the table
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // only fires if a product was selected
                    if(table.getSelectionModel().getSelectedItem() != null)
                    {
                        imgView.setImage(table.getSelectionModel().getSelectedItem().getImg());
                    }
                    else
                    {
                        imgView.setImage(null);
                    }
                }

        );

    }

    /**
     * populates the TableView element with updated data, based on the category and sort option selected.
     * also sets up various elements that need to be updated whenever the TableView is. (total inventory and category values, and selects the first entry in the TableView by default)
     */
    public void popTable()
    {
        ArrayList<Product> list = new ArrayList<>();

        // checks if a category was selected
        if(choiceBox.getValue() != null)
        {
            list.addAll(Inventory.getProductsByCategory(choiceBox.getValue()));
        }
        else
        {
            list.addAll(Inventory.getAllProducts());
        }

        // checks if one of the sort option radio buttons was pressed
        if (optionPressed >= 1 && optionPressed <= 4)
        {
            Collections.sort(list);
        }

        // after desired changes are made to the list, display it
        table.getItems().addAll(list);

        // sets the text for inventoryValue
        ArrayList<Product> totalProducts = new ArrayList<>(Inventory.getAllProducts());
        double totalProductVal = 0.00;
        for(Product product: totalProducts)
        {
            totalProductVal += product.getPrice()*product.getStock();
        }
        inventoryValue.setText("$"+totalProductVal);

        // sets the categoryValue if a category was selected, otherwise, display a prompt to set a category
        if(choiceBox.getValue() != null)
        {
            ArrayList<Product> categoryProducts = new ArrayList<>(Inventory.getProductsByCategory(choiceBox.getValue()));
            double totalCatVal = 0.00;
            for(Product product: categoryProducts)
            {
                totalCatVal += product.getPrice()*product.getStock();
            }
            categoryValue.setText("$"+totalCatVal);
        }
        else
        {
            categoryValue.setText("NO CATEGORY SELECTED");
        }

        // select the first item in the table by default
        table.getSelectionModel().selectFirst();
        imgView.setImage(table.getSelectionModel().getSelectedItem().getImg());
    }

    /**
     * clears the TableView element and calls popTable
     */
    public void reloadTable()
    {
        table.getItems().clear();
        popTable();
    }

    /**
     * fires when the sell button is pushed. reduces the stock of the selected Product by 1, then calls reloadTable()
     *
     * @param actionEvent
     */
    public void sellButtonPressed(ActionEvent actionEvent)
    {
        table.getSelectionModel().getSelectedItem().sellStock();
        reloadTable();
    }

    /**
     * fires when the ordery by price high-low radio button is selected. calls Product.setSortBy(), passing it a 1, and calling reloadTable()
     *
     * @param actionEvent
     */
    public void highLowPressed(ActionEvent actionEvent) {
        optionPressed = 1;
        Product.setSortBy(1);
        reloadTable();
    }

    /**
     * fires when the ordery by price low-high radio button is selected. calls Product.setSortBy(), passing it a 2, and calling reloadTable()
     *
     * @param actionEvent
     */
    public void lowHighPressed(ActionEvent actionEvent) {
        optionPressed = 2;
        Product.setSortBy(2);
        reloadTable();
    }

    /**
     * fires when the ordery by alphabet A-Z radio button is selected. calls Product.setSortBy(), passing it a 3, and calling reloadTable()
     *
     * @param actionEvent
     */
    public void aZPressed(ActionEvent actionEvent) {
        optionPressed = 3;
        Product.setSortBy(3);
        reloadTable();
    }

    /**
     * fires when the ordery by alphabet Z-A radio button is selected. calls Product.setSortBy(), passing it a 4, and calling reloadTable()
     *
     * @param actionEvent
     */
    public void zAPressed(ActionEvent actionEvent) {
        optionPressed = 4;
        Product.setSortBy(4);
        reloadTable();
    }

    /**
     * fires when the reset sorting options button is selected. calls Product.setSortBy(), passing it a 0, unchecks all the radio buttons, sets the choiceBox value to null, and calls reloadTable()
     *
     * @param actionEvent
     */
    public void resetSortButtonPressed(ActionEvent actionEvent) {
        optionPressed = 0;
        Product.setSortBy(0);
        choiceBox.setValue(null);
        reloadTable();
        highLow.setSelected(false);
        lowHigh.setSelected(false);
        aZ.setSelected(false);
        zA.setSelected(false);
    }

    /**
     * fires when the confirm button is pressed. Calls reloadTable().
     * had to use this because the combo box wasn't working when using a change listener
     *
     * @param actionEvent
     */
    public void confirmButtonPressed(ActionEvent actionEvent) {
        reloadTable();
    }
}
