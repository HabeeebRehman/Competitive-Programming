import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private static int atMostK(int[] nums, int k) {
        int left = 0, result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            while (countMap.size() > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}
