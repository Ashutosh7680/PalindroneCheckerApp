// File: UseCase7PalindromeCheckerApp.java

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    // Method to check palindrome using Deque
    public static boolean isPalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Remove first & last and compare until empty
        while (!deque.isEmpty()) {
            // If only one element remains, it's a palindrome
            if (deque.size() == 1) {
                return true;
            }

            // Compare front and rear elements
            char front = deque.removeFirst();  // Remove from front
            char rear = deque.removeLast();    // Remove from rear

            if (front != rear) {
                return false; // Mismatch found
            }
        }

        return true; // All comparisons matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC7: Deque-Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Normalize input (remove spaces, convert to lowercase)
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
