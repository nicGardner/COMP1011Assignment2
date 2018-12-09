package models;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Inventory {

    // the inventory. made static because there is no need to have more than one Inventory, so there is no reason to instantiate it
    private static TreeMap<String, LinkedList<Product>> inventory = new TreeMap<>();

    public  Inventory ()
    {

    }

    /**
     * creates a new entry in the inventory.
     * accepts a String, uses it as the key value, and creates a LinkedList of Products to be the stored value in the new entry.
     *
     * @param category
     */
    public static void addCategory(String category)
    {
        LinkedList<Product> list = new LinkedList<>();
        inventory.put(category, list);
    }

    /**
     * adds a new product to a specified category
     * takes in a  String and a Product as a parameter, using the category as the key value, it retrieves a LinkedList from the inventory and adds the Product value to it
     *
     * @param category
     * @param  product
     */
    public static void addProduct(String category, Product product)
    {
        inventory.get(category).add(product);
    }

    /**
     * retrieves the list of categories used in the inventory
     * retrieves the keys to the inventory as a List of Strings, and returns in
     */
    public static List<String> getCategories()
    {
        List<String> list = new ArrayList<String>(inventory.keySet());
        return list;
    }

    /**
     * retrieves a list of all products
     * retrieves and returns a list of all products made from all the LinkedLists of the inventory
     */
    public static List<Product> getAllProducts()
    {
        List<Product> list = new ArrayList<Product>();
        for(String str: inventory.keySet())
        {
            list.addAll(inventory.get(str));
        }
        return list;
    }

    /**
     * retrieves a list of all the products by a given category
     * accepts a String
     * returns the entry in the inventory with the key coresponding to the parameter
     *
     * @param category
     */
    public static List<Product> getProductsByCategory(String category)
    {
        return inventory.get(category);
    }
}
