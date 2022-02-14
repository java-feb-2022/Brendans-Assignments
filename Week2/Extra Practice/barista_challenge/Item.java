public class Item {
    private String name;
    private double price;

    // Constructors
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
}
