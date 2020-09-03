/**
 * Assignment 2 for my COMP1011 course.
 * A simple app that provides users with a UI for sorting through a mock database of products, including the ability to "sell" products.
 *
 * @author Nic Gardner, 200349007
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Inventory;
import models.PsudeauDB;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/GUI.fxml"));
        primaryStage.setTitle("Assignment 2");
        primaryStage.setScene(new Scene(root, 874, 700));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        // build the psudeau database
        PsudeauDB.buildDB();
        // launch the gui
        launch(args);
    }
}
