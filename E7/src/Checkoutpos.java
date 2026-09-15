import java.time.LocalTime;
import java.util.Scanner;

public class Checkoutpos {

    // Menu prices
    static final double COFFEE_PRICE = 2.50;
    static final double CAKE_PRICE   = 3.75;
    static final double WATER_PRICE  = 1.00;

    // Time-based discount rule (adjust to your spec)
    static final LocalTime HAPPY_START = LocalTime.of(8, 0);
    static final LocalTime HAPPY_END   = LocalTime.of(11, 0);
    static final double DISCOUNT_RATE  = 0.10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        StringBuilder receipt = new StringBuilder();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.printf("1: Coffee  ($%.2f)%n", COFFEE_PRICE);
            System.out.printf("2: Cake    ($%.2f)%n", CAKE_PRICE);
            System.out.printf("3: Water   ($%.2f)%n", WATER_PRICE);
            System.out.println("0: Checkout");
            System.out.print("Choice: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                sc.next();                       // discard bad token
                System.out.println("Invalid input. Numbers only.");
                continue;
            }

            if (choice == 0) break;

            String name;
            double price;
            switch (choice) {
                case 1: name = "Coffee"; price = COFFEE_PRICE; break;
                case 2: name = "Cake";   price = CAKE_PRICE;   break;
                case 3: name = "Water";  price = WATER_PRICE;  break;
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            System.out.print("Quantity: ");
            int qty;
            if (sc.hasNextInt()) {
                qty = sc.nextInt();
            } else {
                sc.next();
                System.out.println("Invalid quantity. Item skipped.");
                continue;
            }
            if (qty <= 0) {
                System.out.println("Quantity must be positive. Item skipped.");
                continue;
            }

            double lineTotal = price * qty;
            total += lineTotal;
            receipt.append(String.format("%-10s x%-3d $%8.2f%n", name, qty, lineTotal));
            System.out.printf("Added: %d x %s = $%.2f | Running total: $%.2f%n",
                    qty, name, lineTotal, total);
        }

        // ---- Checkout ----
        LocalTime now = LocalTime.now();
        boolean discountApplies = !now.isBefore(HAPPY_START) && now.isBefore(HAPPY_END);
        double discount = discountApplies ? total * DISCOUNT_RATE : 0.0;
        double finalTotal = total - discount;

        System.out.println("\n========= RECEIPT =========");
        if (receipt.length() == 0) {
            System.out.println("(no items purchased)");
        } else {
            System.out.print(receipt);
        }
        System.out.println("---------------------------");
        System.out.printf("Subtotal:          $%8.2f%n", total);
        if (discountApplies) {
            System.out.printf("Happy Hour (-10%%): -$%8.2f%n", discount);
        }
        System.out.printf("TOTAL:             $%8.2f%n", finalTotal);
        System.out.println("===========================");
        System.out.println("Time: " + now.withNano(0));

        sc.close();
    }
}