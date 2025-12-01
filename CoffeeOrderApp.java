import java.util.Scanner;

public class CoffeeOrderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Brewtiful Coffee Shop ===");
        System.out.println("Welcome! Let's create your custom coffee order.\n");
        
        // Choose base coffee
        Coffee coffee = chooseBaseCoffee(scanner);
        
        // Add toppings
        coffee = addToppings(scanner, coffee);
        
        // Display final order
        System.out.println("\n=== Your Order Summary ===");
        printOrder(coffee);
        
        scanner.close();
    }
    
    private static Coffee chooseBaseCoffee(Scanner scanner) {
        System.out.println("Choose your base coffee:");
        System.out.println("1. Black Coffee - ₱100.00");
        System.out.println("2. Espresso - ₱120.00");
        System.out.print("Enter your choice (1-2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                return new BlackCoffee();
            case 2:
                return new Espresso();
            default:
                System.out.println("Invalid choice. Defaulting to Black Coffee.");
                return new BlackCoffee();
        }
    }
    
    private static Coffee addToppings(Scanner scanner, Coffee coffee) {
        boolean addingMore = true;
        
        System.out.println("\nNow let's add toppings (enter 0 when done):");
        
        while (addingMore) {
            System.out.println("\nCurrent order: " + coffee.getDescription());
            System.out.println("Current cost: ₱" + String.format("%.2f", coffee.getCost()));
            System.out.println("\nAvailable toppings:");
            System.out.println("1. Milk - ₱25.00");
            System.out.println("2. Sugar - ₱10.00");
            System.out.println("3. Caramel Syrup - ₱40.00");
            System.out.println("0. Finish order");
            System.out.print("Choose a topping (0-3): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 0:
                    addingMore = false;
                    System.out.println("Finishing your order...");
                    break;
                case 1:
                    coffee = new Milk(coffee);
                    System.out.println("✓ Milk added!");
                    break;
                case 2:
                    coffee = new Sugar(coffee);
                    System.out.println("✓ Sugar added!");
                    break;
                case 3:
                    coffee = new CaramelSyrup(coffee);
                    System.out.println("✓ Caramel Syrup added!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        return coffee;
    }
    
    private static void printOrder(Coffee coffee) {
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Total Cost: ₱" + String.format("%.2f", coffee.getCost()));
        System.out.println("\nThank you for your order! Enjoy your coffee! ☕");
    }
}