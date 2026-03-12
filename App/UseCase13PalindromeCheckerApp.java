import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // Algorithm 1: Two Pointer Approach
    public static boolean twoPointerApproach(String s) {
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

    // Algorithm 2: Stack Approach
    public static boolean stackApproach(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : s.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }
        return true;
    }

    // Algorithm 3: Deque Approach
    public static boolean dequeApproach(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            deque.addLast(ch);
        }
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                return true;
            }
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }

    // Algorithm 4: Recursive Approach
    public static boolean recursiveApproach(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return recursiveApproach(s, left + 1, right - 1);
    }

    public static boolean recursiveApproach(String s) {
        return recursiveApproach(s, 0, s.length() - 1);
    }

    // Algorithm 5: String Reverse Approach
    public static boolean stringReverseApproach(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    // Performance testing method
    public static void measurePerformance(String input, int iterations) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\n=== Performance Comparison Results ===");
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Normalized: \"" + normalized + "\"");
        System.out.println("Iterations: " + iterations);
        System.out.println("String Length: " + normalized.length());
        System.out.println("\n" + String.format("%-30s | %-15s | %-10s", 
            "Algorithm", "Time (ns)", "Result"));
        System.out.println(String.format("%-30s-+-%-15s-+-%-10s", 
            "------------------------------", "---------------", "----------"));

        // Test 1: Two Pointer
        long startTime = System.nanoTime();
        boolean result = false;
        for (int i = 0; i < iterations; i++) {
            result = twoPointerApproach(normalized);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / iterations;
        System.out.println(String.format("%-30s | %-15d | %-10s", 
            "Two Pointer", duration, result));

        // Test 2: Stack
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            result = stackApproach(normalized);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / iterations;
        System.out.println(String.format("%-30s | %-15d | %-10s", 
            "Stack", duration, result));

        // Test 3: Deque
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            result = dequeApproach(normalized);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / iterations;
        System.out.println(String.format("%-30s | %-15d | %-10s", 
            "Deque", duration, result));

        // Test 4: Recursive
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            result = recursiveApproach(normalized);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / iterations;
        System.out.println(String.format("%-30s | %-15d | %-10s", 
            "Recursive", duration, result));

        // Test 5: String Reverse
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            result = stringReverseApproach(normalized);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / iterations;
        System.out.println(String.format("%-30s | %-15d | %-10s", 
            "String Reverse", duration, result));

        System.out.println("\nNote: Time measured in nanoseconds (ns)");
        System.out.println("Lower values indicate faster execution");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.print("Enter number of iterations (default 1000): ");
        String iterInput = sc.nextLine();
        int iterations = iterInput.isEmpty() ? 1000 : Integer.parseInt(iterInput);

        // Run performance comparison
        measurePerformance(input, iterations);

        sc.close();
    }
}
