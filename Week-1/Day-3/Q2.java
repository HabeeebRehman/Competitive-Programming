public class Q2 {
    public static void main(String[] args) {
        System.out.println(gcd(54, 24)); // 6
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
