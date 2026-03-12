public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "madam";
        
        // Reverse the string using a loop
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        
        // Compare original and reversed strings
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}