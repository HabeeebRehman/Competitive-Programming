public class Q3 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prevMax = 0, currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + num);
            prevMax = temp;
        }
        return currMax;
    }
}
