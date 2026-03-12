// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class PalindromeCheckerApp {
   public PalindromeCheckerApp() {
   }

   public static void main(String[] var0) {
        String word = "odd";
        
        String reversed = new StringBuilder(word).reverse().toString();
        
        if (word.equals(reversed)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
   }
}
