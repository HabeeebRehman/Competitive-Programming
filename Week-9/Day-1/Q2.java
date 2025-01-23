import java.util.*;

public class Q2 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private static void generatePermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            generatePermutations(nums, current, used, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Permutations: " + permute(nums));
    }
}
