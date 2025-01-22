public class Q1 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}
