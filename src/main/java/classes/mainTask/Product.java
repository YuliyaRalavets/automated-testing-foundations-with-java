package classes.mainTask;

public class Product {
    private int id;
    private String name;
    private long upc;
    private String manufacturer;
    private double price;
    private  int selfLife;
    private int quantity;


    public Product() {
    }

    public Product(int id, String name, long upc, String manufacturer, double price, int selfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.selfLife = selfLife;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSelfLife() {
        return selfLife;
    }

    public void setSelfLife(int selfLife) {
        this.selfLife = selfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " id = " + getId() + "; " + "name = " + getName() + "; " + "upc = " + getUpc() + "; "
                + "manufacturer = " + getManufacturer() + "; " + "price = " + getPrice() + "; "
                + "selfLife = " + getSelfLife() + " days; " + "quantity = " + getQuantity() + ".";
    }
}

