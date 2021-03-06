package models;

import java.awt.*;
import java.io.File;
import javafx.scene.image.Image;

public class PsudeauDB {
    public PsudeauDB()
    {
        // 3 Phones
        Product phone1 = new Product("Samsung Galaxy S8", null, new Image(getClass().getResource("/models/pics/Samsung-Galaxy-S8.jpg").toExternalForm()), 1199.99, 10);
        Product phone2 = new Product("iPhone X", null, (new Image(getClass().getResource("/models/pics/iPhone-X.jpg").toExternalForm())), 1399.99, 7);
        Product phone3 = new Product("Blackberry Z10", null, (new Image(getClass().getResource("/models/pics/Blackberry-Z10.jpg").toExternalForm())), 799.99, 12);

        // 3 TVs
        Product tv1 = new Product("Sharp TV", null, (new Image(getClass().getResource("/models/pics/Sharp-tv.jpg").toExternalForm())), 599.99, 50);
        Product tv2 = new Product("LG TV", null, (new Image(getClass().getResource("/models/pics/LG-tv.jpg").toExternalForm())), 479.99, 25);
        Product tv3 = new Product("Samsung TV", null, (new Image(getClass().getResource("/models/pics/Samsung-tv.jpg").toExternalForm())), 699.99, 32);

        // 3 Movies
        Product  movie1 = new Product("Firefly", "RIP", (new Image(getClass().getResource("/models/pics/Firefly.jpg").toExternalForm())), 25.99, 4);
        Product movie2 = new Product("Star Wars The Last Jedi", null, (new Image(getClass().getResource("/models/pics/TLJ.jpg").toExternalForm())), 43.99, 7);
        Product movie3 = new Product("Die Hard", null, (new Image(getClass().getResource("/models/pics/DieHard.jpg").toExternalForm())), 12.99, 23);


        // create the categories
        Inventory.addCategory("Phones");
        Inventory.addCategory("TVs");
        Inventory.addCategory("Movies");

        // add the items to the inventory
        Inventory.addProduct("Phones", phone1);
        Inventory.addProduct("Phones", phone2);
        Inventory.addProduct("Phones", phone3);

        Inventory.addProduct("TVs", tv1);
        Inventory.addProduct("TVs", tv2);
        Inventory.addProduct("TVs", tv3);

        Inventory.addProduct("Movies", movie1);
        Inventory.addProduct("Movies", movie2);
        Inventory.addProduct("Movies", movie3);
    }

    /**
     * static method that creates 3 categories, and 3 products for each category, and enters them into Inventory to be used as a mock database
     */
    public static void buildDB ()
    {
        PsudeauDB psudeauDB = new PsudeauDB();
        return;
    }
}
