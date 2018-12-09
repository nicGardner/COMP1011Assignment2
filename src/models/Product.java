package models;

import javafx.scene.image.Image;

public class Product {

    private String name, desc;
    private Image img;
    private double price;
    private int stock;

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

    public String toString()
    {
        return name + ": $" + price + " (" + stock + " units in stock)";
    }
}
