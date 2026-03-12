public class UseCase10PalindromeCheckerApp {

    // Checks palindrome by two-pointer technique on already normalized string
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize input: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("Result: \"" + input + "\" is a Palindrome (case & spaces ignored).");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome (case & spaces ignored).");
        }

        sc.close();
    }
}