import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) continue;
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, current, i);
            current.remove(current.size() - 1);
        }
    }
}
