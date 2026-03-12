public class UseCase4PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "madam";
        
        // Convert string to character array
        char[] chars = word.toCharArray();
        
        // Use two-pointer approach to check palindrome
        boolean isPalindrome = true;
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            if (chars[left] != chars[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        
        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}