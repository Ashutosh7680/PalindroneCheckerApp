import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String word = "madam";
        
        // Create Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        
        // Enqueue and push characters
        for (char c : word.toCharArray()) {
            queue.offer(c);
            stack.push(c);
        }
        
        // Compare dequeue (from front) with pop (from top)
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }
        
        // Display result
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
} 