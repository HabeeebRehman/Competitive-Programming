import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            backtrack(nums, result, current);
            current.remove(current.size() - 1);
        }
    }
}
