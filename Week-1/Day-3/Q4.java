public class Q4 {
    public static void main(String[] args) {
        System.out.println(power(2, 5)); // 32
    }

    public static int power(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            result *= base;
            exp--;
        }
        return result;
    }
}
