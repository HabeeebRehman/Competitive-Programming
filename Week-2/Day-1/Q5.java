public class Q5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int num : result) System.out.print(num + " ");
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 1, right = 1;
        for (int i = 0; i < n; i++) result[i] = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
