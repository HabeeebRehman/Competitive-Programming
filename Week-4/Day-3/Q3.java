import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
