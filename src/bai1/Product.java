package bai1;

public class Product {
    public static int INDEX;
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String type;

    public Product() {
    }

    public Product(String name, int price, int quantity, String type) {
        this.id = ++INDEX;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + quantity + "," + type;
    }
}

