package main.edu.testdome.java;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int n = word.length();

        for (int i = 0; i < n/2; i++) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }

}
