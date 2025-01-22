import java.util.HashMap;

public class Q3 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubarrayWithSumK(nums, k));
    }

    public static int longestSubarrayWithSumK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) maxLen = i + 1;
            if (map.containsKey(sum - k)) maxLen = Math.max(maxLen, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }
        return maxLen;
    }
}
