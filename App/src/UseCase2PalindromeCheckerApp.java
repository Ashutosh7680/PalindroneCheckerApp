public class UseCase2PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "odd";
        
        // Check if the string is a palindrome
        String reversed = new StringBuilder(word).reverse().toString();
        
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome. ");
        } else {
            System.out.println(word + " is not a palindrome. bhaiiii");
        }
    }
}