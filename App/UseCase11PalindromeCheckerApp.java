// PalindromeChecker class - encapsulates palindrome checking logic
class PalindromeChecker {
    private String input;
    private String normalized;

    public PalindromeChecker(String input) {
        this.input = input;
        this.normalized = input.replaceAll("\\s+", "").toLowerCase();
    }

    // checkPalindrome method - single responsibility
    public boolean checkPalindrome() {
        int left = 0;
        int right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // getter for original input
    public String getOriginalInput() {
        return input;
    }

    // getter for normalized input
    public String getNormalizedInput() {
        return normalized;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Service ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create PalindromeChecker service
        PalindromeChecker checker = new PalindromeChecker(input);

        // Use the service to check palindrome
        boolean result = checker.checkPalindrome();

        if (result) {
            System.out.println("Result: \"" + checker.getOriginalInput() + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + checker.getOriginalInput() + "\" is NOT a Palindrome.");
        }

        System.out.println("Normalized: \"" + checker.getNormalizedInput() + "\"");

        sc.close();
    }
}
