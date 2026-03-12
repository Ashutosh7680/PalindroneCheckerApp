import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Strategy Interface for different palindrome algorithms
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack-based Strategy Implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : input.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based Strategy Implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) {
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
}

// Two-Pointer Strategy Implementation
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Palindrome Checker Service with Strategy Injection
class PalindromeCheckerService {
    private PalindromeStrategy strategy;

    public PalindromeCheckerService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Allow strategy change at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return strategy.check(normalized);
    }
}

// Main Application Class
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern for Palindrome Algorithms ===");
        System.out.println("Choose a strategy:");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.println("3. Two-Pointer");
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        PalindromeStrategy strategy;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                System.out.println("Strategy: Stack-based Algorithm");
                break;
            case 2:
                strategy = new DequeStrategy();
                System.out.println("Strategy: Deque-based Algorithm");
                break;
            case 3:
                strategy = new TwoPointerStrategy();
                System.out.println("Strategy: Two-Pointer Algorithm");
                break;
            default:
                strategy = new TwoPointerStrategy();
                System.out.println("Invalid choice. Using Two-Pointer Algorithm.");
        }

        // Create service with chosen strategy
        PalindromeCheckerService service = new PalindromeCheckerService(strategy);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Check palindrome using selected strategy
        boolean result = service.checkPalindrome(input);

        if (result) {
            System.out.println("Result: \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a Palindrome.");
        }

        sc.close();
    }
}
