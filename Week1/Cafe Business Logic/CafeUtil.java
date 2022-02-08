import java.util.ArrayList;
public class CafeUtil {
    
    public int getStreakGoal() {
        int numWeeks = 10, sum = 0;
        for(int i=0;i<=numWeeks;i++) {
            sum = sum + i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for(double price : prices) {
            sum = sum + price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(int i=0;i<menuItems.size();i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.printf("There are(is) %s people in front of you. \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
}