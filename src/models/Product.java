package models;

import javafx.scene.image.Image;

public class Product implements Comparable<Product>{

    private String name, desc;
    private Image img;
    private double price;
    private int stock;

    // specifies which method of sorting is being used.  1 = price high-low, 2 = price low-high, 3 = name a-z, 4 = name z-a
    // is static because all Products need to have the same sorting algorithm
    private static int sortBy = 1;

    public Product(String name, String desc, Image img, double price, int stock)
    {
        setName(name);
        setImg(img);
        setPrice(price);
        setStock(stock);
        setDesc();
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
        if (name != null)
        {
            if (name.length() < 30)
            {
                this.name = name;
            }
            else
            {
                throw new IllegalArgumentException("name values must be less than 30 characters long");
            }

        }
        else
        {
            throw new IllegalArgumentException("name values must not be null");
        }
    }

    public void setDesc() {
        if (toString().length() > 21)
        {
            this.desc = toString();
        }
        else
        {
            throw new IllegalArgumentException("Error, no values were added to the toString");
        }
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setPrice(double price) {
        if (price > 0)
        {
            this.price = price;
        }
        else
        {
            throw new IllegalArgumentException("price value must be a positive number");
        }

    }

    public void setStock(int stock) {
        if (stock >= 0)
        {
            this.stock = stock;
        }
        else
        {
            throw new IllegalArgumentException("stock value can be zero, but it must not be a negative number");
        }
    }

    /**
     * validates that the remaining stock is greater than zero, and reduces it by one, calls setDesc() to update the description to include the change.
     */
    public void sellStock()
    {
        if (stock > 0)
        {
            stock --;
            setDesc();
        }
        else
        {
            System.out.println("no stock to sell");
        }

    }

    /**
     * used to set the desired sorting algorithm
     * static method so it effects all Products
     * accepts an int as a parameter, validates that it s between 0 and 4, and sets the static int sortBy to the value of the parameter
     *
     * @param i
     */
    public static void setSortBy(int i)
    {
        if (sortBy >= 0 && sortBy <= 4)
        {
            sortBy = i;
        }
        else
        {
            throw new IllegalArgumentException("sortBy value must be between 0 and 4");
        }
    }

    /**
     * takes in a Product as a parameter, and compares the product based on the sorting algorithm chosen in setSortBy()
     * return an int
     *
     * @param p
     */
    @Override
    public int compareTo(Product p)
    {
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
        // default to not sorting
        return 0;

    }

    /**
     * concatinates the name, price, and remaining stock as a single string to be used as the product description
     */
    public String toString()
    {
        return name + ": $" + price + " (" + stock + " units in stock)";
    }
}
