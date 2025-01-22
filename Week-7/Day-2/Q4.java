public class Q4 {
    public static int equal(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
        }

        int result = Integer.MAX_VALUE;
        for (int base = 0; base < 5; base++) {
            int operations = 0;
            for (int num : arr) {
                int diff = num - (min - base);
                operations += diff / 5 + (diff % 5) / 2 + (diff % 5) % 2;
            }
            result = Math.min(result, operations);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 7};
        System.out.println(equal(arr));
    }
}
