package models;

public class PsudeauDB {
    public PsudeauDB(){}
    public static void buildDB ()
    {
        // 3 Phones
        Product phone1 = new Product("Samsung Galaxy S8", "Smartphone by Samgsung", null, 1199.99, 10);
        Product phone2 = new Product("iPhone X", "Smartphone by Apple", null, 1399.99, 7);
        Product phone3 = new Product("Blackberry", "Smartphone by Blackberry", null, 799.99, 12);

        // 3 TVs
        Product tv1 = new Product("Sharp", "TV by Sharp", null, 599.99, 50);
        Product tv2 = new Product("LG", "TV by LG", null, 479.99, 25);
        Product tv3 = new Product("Samsung", "TV by Samsung", null, 699.99, 32);

        // 3 Movies
        Product  movie1 = new Product("Firefly", "RIP", null, 25.99, 4);
        Product movie2 = new Product("Star Wars The Last Jedi", "I'm just gonna say it, it's a good movie. Don't @ me.", null, 43.99, 7);
        Product movie3 = new Product("Harry Potter And The Prisoner Of Askaban", "A movie about a kid who has magic", null, 12.99, 23);


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
}
