import java.util.Stack;

public class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "madam";
        
        // Use stack to reverse the string
        Stack<Character> stack = new Stack<>();
        
        // Push characters into stack
        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        
        // Pop characters to build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        // Compare original and reversed strings
        if (word.equals(reversed.toString())) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}