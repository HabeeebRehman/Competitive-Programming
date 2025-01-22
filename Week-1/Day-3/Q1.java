public class Q1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(123)); // false
    }

    public static boolean isPalindrome(int num) {
        int reversed = 0, original = num;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }
}
