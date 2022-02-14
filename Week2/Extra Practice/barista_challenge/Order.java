import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    // Constructors
    public Order() {
        this.name = "Guest";
        this.ready = false;
    }
    // Overload
    public Order(String name) {
        this.name = name;
        this.ready = false;
    }
    // Order methods
    public void addItem(Item item) {
        this.items.add(item);
    }
    public String getStatusMessage() {
        if(this.ready == true) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public double getOrderTotal() {
        double sum = 0;
        for(Item i : this.items) {
            sum += i.getPrice();
        }
        return sum;
    }
    public void display() {
        System.out.printf("Customer Name: %s\n", this.name);
        for(Item i : this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }
    public void isReady(boolean ready) {
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> item) {
        this.items = item;
    }
    public String getName() {
        return this.name;
    }
    public boolean getReady() {
        return this.ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
}

