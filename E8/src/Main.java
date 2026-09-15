import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] english = {
                "hello", "thank you", "computer", "student",
                "teacher", "book", "water", "school"
        };

        String[] khmer = {
                "សួស្តី", "អរគុណ", "កុំព្យូទ័រ", "និស្សិត",
                "គ្រូ", "សៀវភៅ", "ទឹក", "សាលារៀន"
        };

        System.out.println("=== International Translation Portal ===");
        System.out.println("Type a word in English or Khmer.");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            System.out.print("Enter a word: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            boolean found = false;

            for (int i = 0; i < english.length; i++) {   // ← brace 7 (for)
                if (input.equalsIgnoreCase(english[i])) { // ← brace 8
                    System.out.println("Khmer: " + khmer[i]);
                    found = true;
                    break;
                }                                   // ← closes brace 8
                if (input.equalsIgnoreCase(khmer[i])) {   // ← brace 9
                    System.out.println("English: " + english[i]);
                    found = true;
                    break;
                }                                   // ← closes brace 9
            }                                       // ← closes brace 7 (for)

            if (!found) {                           // ← brace 10 (if)
                System.out.println("Translation not found.");
            }                                       // ← closes brace 10

            System.out.println();
        }                                           // ← closes brace 5 (while)

        scanner.close();
    }                                               // ← closes brace 2 (main)
}                                                   // ← closes brace 1 (class)