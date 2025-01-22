import java.util.*;

public class Q4 {
    public static List<Integer> mergeKSortedArrays(List<List<Integer>> lists) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) {
                minHeap.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int value = curr[0];
            int listIndex = curr[1];
            int elementIndex = curr[2];

            result.add(value);

            if (elementIndex + 1 < lists.get(listIndex).size()) {
                minHeap.offer(new int[]{lists.get(listIndex).get(elementIndex + 1), listIndex, elementIndex + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 4, 7));
        lists.add(Arrays.asList(2, 5, 8));
        lists.add(Arrays.asList(3, 6, 9));

        List<Integer> merged = mergeKSortedArrays(lists);
        System.out.println("Merged Sorted Array: " + merged); 
    }
}
