import java.util.*;

public class Q2 {
    private PriorityQueue<Integer> lowerHalf, upperHalf;

    public Q2() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        upperHalf = new PriorityQueue<>();
    }

    public void insert(int num) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.offer(num);
        } else {
            upperHalf.offer(num);
        }

        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        } else {
            return lowerHalf.peek();
        }
    }

    public static void main(String[] args) {
        Q2 mf = new Q2();
        mf.insert(1);
        mf.insert(2);
        System.out.println("Median: " + mf.findMedian()); // Output: 1.5
        mf.insert(3);
        System.out.println("Median: " + mf.findMedian()); // Output: 2
    }
}
