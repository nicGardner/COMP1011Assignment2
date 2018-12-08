package models;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Inventory {

    private static TreeMap<String, LinkedList<Product>> inventory = new TreeMap<>();

    public  Inventory ()
    {

    }

    public static void addCategory(String category)
    {
        System.out.println("adding category "+category);
        LinkedList<Product> list = new LinkedList<>();
        inventory.put(category, list);
    }

    public static void addProduct(String category, Product product)
    {
        inventory.get(category).add(product);
    }

    public static List<String> getCategories()
    {
        List<String> list = new ArrayList<String>(inventory.keySet());
        return list;
    }

    public static List<Product> getAllProducts()
    {
        List<Product> list = new ArrayList<Product>();
        for(String str: inventory.keySet())
        {
            list.addAll(inventory.get(str));
        }
        return list;
    }

    public static List<Product> getProductsByCategory(String category)
    {
        return inventory.get(category);
    }
}
