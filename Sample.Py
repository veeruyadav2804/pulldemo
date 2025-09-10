# Simple Order System in Python

class Order:
    def __init__(self, order_id, customer_name):
        self.order_id = order_id
        self.customer_name = customer_name
        self.items = []
        self.status = "Pending"

    def add_item(self, item_name, price, quantity=1):
        self.items.append({
            "item_name": item_name,
            "price": price,
            "quantity": quantity
        })

    def total_price(self):
        return sum(item["price"] * item["quantity"] for item in self.items)

    def update_status(self, new_status):
        self.status = new_status

    def display_order(self):
        print(f"\nOrder ID: {self.order_id}")
        print(f"Customer: {self.customer_name}")
        print(f"Status: {self.status}")
        print("Items:")
        for item in self.items:
            print(f"  - {item['item_name']} x{item['quantity']} @ ${item['price']} each")
        print(f"Total: ${self.total_price():.2f}")


# Example usage
if __name__ == "__main__":
    # Create an order
    order1 = Order(order_id=101, customer_name="Alice")

    # Add items
    order1.add_item("Laptop", 999.99, 1)
    order1.add_item("Mouse", 25.50, 2)

    # Display order before shipping
    order1.display_order()

    # Update order status
    order1.update_status("Shipped")

    # Display order after shipping
    order1.display_order()
