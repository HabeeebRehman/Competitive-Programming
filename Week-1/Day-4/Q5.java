public class Q5 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam")); // true
    }

    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
