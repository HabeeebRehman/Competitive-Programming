import java.util.*;

public class Q3 {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public Q3(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
      Q3 kthLargest = new Q3(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
    }
}
