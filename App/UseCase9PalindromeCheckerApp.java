public class UseCase9PalindromeCheckerApp {

    // recursive method to check palindrome
    public static boolean isPalindrome(String s, int left, int right) {
        // base condition: crossed pointers or single char
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    // convenience wrapper
    public static boolean isPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("=== UC9: Recursive Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("Result: \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome.");
        }

        sc.close();
    }
}
