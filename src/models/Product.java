package models;

import javafx.scene.image.Image;

public class Product implements Comparable<Product>{

    private String name, desc;
    private Image img;
    private double price;
    private int stock;

    // specifies which method of sorting is being used.  1 = price high-low, 2 = price low-high, 3 = name a-z, 4 = name z-a
    private static int sortBy = 1;

    public Product(String name, String desc, Image img, double price, int stock)
    {
        setName(name);
        setImg(img);
        setPrice(price);
        setStock(stock);
        setDesc(desc);
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Image getImg() {
        return img;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        //this.desc = desc;
        this.desc = toString();
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void sellStock()
    {
        if (stock > 0)
        {
            stock --;
            setDesc(toString());
            System.out.println("stock sold. new stock for "+name+": "+stock);
        }
        else
        {
            System.out.println("no stock to sell");
        }

    }

    public static void setSortBy(int i)
    {
        sortBy = i;
    }

    @Override
    public int compareTo(Product p)
    {
        System.out.println(sortBy);
        if(sortBy == 1)
        {
            // sorts price high-low
            if (this.getPrice() > p.getPrice())
            {
                return -1;
            }
            else if (this.getPrice() < p.getPrice())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else if (sortBy == 2)
        {
            // sorts price low-high
            if (this.getPrice() > p.getPrice())
            {
                return 1;
            }
            else if (this.getPrice() < p.getPrice())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        else if (sortBy == 3)
        {
            // sorts alphabetically a-z
            return this.getName().compareToIgnoreCase(p.getName());
        }
        else if (sortBy == 4)
        {
            // sorts alphabetically z-a
            return (this.getName().compareToIgnoreCase(p.getName()))*-1;
        }

        // default to sorting alphabetically a-z
        //return this.getName().compareToIgnoreCase(p.getName());
        // default to not sorting
        return 0;

    }

    public String toString()
    {
        return name + ": $" + price + " (" + stock + " units in stock)";
    }
}
