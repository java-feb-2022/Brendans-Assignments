import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        // Menu Items
        Item item1 = new Item("cappucino",3.75);
        Item item2 = new Item("mocha",5);
        Item item3 = new Item("latte",4.5);
        Item item4 = new Item("drip coffee",1.5);
        // Guest Orders
        Order order1 = new Order();
        Order order2 = new Order();
        // Overload Orders
        Order order3 = new Order("Brendan");
        Order order4 = new Order("John");
        Order order5 = new Order("Zach");
        // Add Items
        order1.addItem(item1);
        order1.addItem(item4);
        order2.addItem(item2);
        order2.addItem(item1);
        order3.addItem(item3);
        order3.addItem(item4);
        order4.addItem(item3);
        order4.addItem(item1);
        order5.addItem(item2);
        order5.addItem(item2);
        // Display orders
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
        // Status message test
        order2.isReady(true);
        order4.isReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());
        // Test getTotal
        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());
        System.out.println(order5.getOrderTotal());
        // Display again
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
