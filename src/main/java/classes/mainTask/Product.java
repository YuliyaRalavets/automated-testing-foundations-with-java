package classes.mainTask;

public class Product {
    private int id;
    private String name;
    private int UPC;
    private String manufacturer;
    private double price;
    private int selfLife;
    private int quantity;

    public Product() {
    }

    public Product(int id, String name, int UPC, String manufacturer, double price, int selfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.UPC = UPC;
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

    public int getUPC() {
        return UPC;
    }

    public void setUPC(int UPC) {
        this.UPC = UPC;
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
        return " id = " + getId() + "; " + "name = " + getName() + "; " + "UPC = " + getUPC() + "; "
                + "manufacturer = " + getManufacturer() + "; " + "price = " + getPrice() + "; "
                + "selfLife = " + getSelfLife() + " days; " + "quantity = " + getQuantity() + ".";
    }
}
