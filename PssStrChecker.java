import java.util.Scanner;

public class PssStrChecker {

       public static boolean containsSpecial(String s) {
        for (char c : s.toCharArray()) {
            if (c == '!' || c == '#' || c == '$') return true;
        }
        return false;
       }

        public static boolean containsUpper(String s) {
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    public static boolean containsDigit(String s) {
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score;

        System.out.print("Enter Username: ");
        String username = scanner.next();

        do {
            score = 0;

            System.out.print("Enter Password: ");
            String password = scanner.next();

            if (password.length() >= 8) score++;
            if (containsSpecial(password)) score++;
            if (containsUpper(password)) score++;
            if (containsDigit(password)) score++;
            if (!password.equals(username)) score++;

            String rating;

            if (score >= 5) {
                rating = "Strong";
            } else if (score >= 3) {
                rating = "Medium";
            } else {
                rating = "Weak";
            }
            
            if (score >= 5) {
                System.out.println("Rating: " + rating + "! Password accepted.");
            } else {
                System.out.println("Rating: " + rating + ". Please try again.");
            }
                
            
        } while (score < 5);

        scanner.close();
    }
}