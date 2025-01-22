import java.util.*;

public class Q3 {
    public static List<Integer> getTopKTrafficSources(int[] traffic, int k) {
        Map<Integer, Integer> trafficMap = new HashMap<>();
        for (int source : traffic) {
            trafficMap.put(source, trafficMap.getOrDefault(source, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        pq.addAll(trafficMap.entrySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] traffic = {1, 2, 2, 3, 3, 3, 4};
        int k = 2;
        System.out.println("Top K traffic sources: " + getTopKTrafficSources(traffic, k)); // Output: [3, 2]
    }
}
