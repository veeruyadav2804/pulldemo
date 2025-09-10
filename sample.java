import java.util.ArrayList;
import java.util.List;

// Class to represent an item in the order
class OrderItem {
    private String name;
    private int quantity;
    private double price;

    public OrderItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return quantity + " x " + name + " @ " + price + " = " + getTotal();
    }
}

// Class to represent an order
class Order {
    private int orderId;
    private List<OrderItem> items;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        for (OrderItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: " + getTotalAmount());
    }
}

// Main class to test the order system
public class OrderSystem {
    public static void main(String[] args) {
        Order order = new Order(1001);
        
        order.addItem(new OrderItem("Laptop", 1, 750.00));
        order.addItem(new OrderItem("Mouse", 2, 25.50));
        order.addItem(new OrderItem("Keyboard", 1, 45.99));
        
        order.printOrder();
    }
}
