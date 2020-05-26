package model;

public class Product {
    private int productId;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private String descr;
    private int cateId;

    public Product() {
    }

    public Product(String name, float price, int quantity, String color, String descr, int cateId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descr = descr;
        this.cateId = cateId;
    }

    public Product(int productId, String name, float price, int quantity, String color, String descr, int cateId) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descr = descr;
        this.cateId = cateId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
}
