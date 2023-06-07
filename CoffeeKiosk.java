import java.util.ArrayList;
import java.util.Scanner;

class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        int index = menu.size();
        newItem.setIndex(index);
        menu.add(newItem);
    }

    public void displayMenu() {
        System.out.println("Menu:");

        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter customer name for new order:");
        String name = scanner.nextLine();

        Order order = new Order(name);
        displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = scanner.nextLine();

        while (!itemNumber.equals("q")) {
            int index = Integer.parseInt(itemNumber);

            if (index >= 0 && index < menu.size()) {
                Item selectedItem = menu.get(index);
                order.addItem(selectedItem);
            }

            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = scanner.nextLine();
        }

        orders.add(order);

        System.out.println("Order placed successfully!");

        order.display();
    }
}