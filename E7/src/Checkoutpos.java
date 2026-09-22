import java.util.Scanner;



    public static void main(String[] args) {

         double COFFEE_PRICE = 2.50;
        double CAKE_PRICE   = 3.75;
        double WATER_PRICE  = 1.00;
        double DISCOUNT_RATE = 0.10;
        int HAPPY_START = 8;
        int HAPPY_END   = 11;

        Scanner input = new Scanner(System.in);

        double total = 0.0;
        String receipt = "";

        while (true) {
            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1: Coffee ($" + COFFEE_PRICE + ")");
            System.out.println("2: Cake   ($" + CAKE_PRICE + ")");
            System.out.println("3: Water  ($" + WATER_PRICE + ")");
            System.out.println("0: Checkout");
            System.out.print("Choice: ");

            int choice;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();                       // discard bad token
                System.out.println("Invalid input. Numbers only.");
                continue;                            // Chapter 5: continue
            }

            if (choice == 0) {
                break;                               // Chapter 5: break
            }


            String name;
            double price;
            switch (choice) {
                case 1:
                    name = "Coffee";
                    price = COFFEE_PRICE;
                    break;
                case 2:
                    name = "Cake";
                    price = CAKE_PRICE;
                    break;
                case 3:
                    name = "Water";
                    price = WATER_PRICE;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    continue;
            }

            System.out.print("Quantity: ");
            int qty;
            if (input.hasNextInt()) {
                qty = input.nextInt();
            } else {
                input.next();
                System.out.println("Invalid quantity. Item skipped.");
                continue;
            }

            // ---- Chapter 3: one-way if with relational operator ----
            if (qty <= 0) {
                System.out.println("Quantity must be positive. Item skipped.");
                continue;
            }

            double lineTotal = price * qty;
            total += lineTotal;                     // Chapter 2: augmented assignment

            receipt = receipt + name + " x" + qty + " = $" + lineTotal + "\n";

            System.out.println("Added: " + qty + " x " + name + " = $" + lineTotal
                    + " | Running total: $" + total);
            break;
        }

        // ---- Ask for the hour instead of reading the system clock ----
        System.out.print("\nEnter the current hour (0-23) for Happy Hour check: ");
        int hour = -1;
        if (input.hasNextInt()) {
            hour = input.nextInt();
        }


        boolean discountApplies = (hour >= HAPPY_START) && (hour < HAPPY_END);

        double discount = 0.0;
        if (discountApplies) {
            discount = total * DISCOUNT_RATE;
        }
        double finalTotal = total - discount;

        // ---- Receipt ----
        System.out.println("\n========= RECEIPT =========");
        if (receipt.equals("")) {
            System.out.println("(no items purchased)");
        } else {
            System.out.print(receipt);
        }
        System.out.println("---------------------------");
        System.out.println("Subtotal: $" + total);
        if (discountApplies) {
            System.out.println("Happy Hour (-10%): -$" + discount);
        }
        System.out.println("TOTAL: $" + finalTotal);
        System.out.println("===========================");

        input.close();
    }
