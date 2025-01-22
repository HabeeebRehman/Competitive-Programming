public class Q1 {
    private int[] segmentTree;
    private int n;

    public Q1(int[] nums) {
        n = nums.length;
        segmentTree = new int[2 * n];
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        int diff = val - segmentTree[n + index];
        segmentTree[n + index] = val;
        index += n;
        while (index > 1) {
            index /= 2;
            segmentTree[index] += diff;
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        left += n;
        right += n + 1;
        while (left < right) {
            if (left % 2 == 1) sum += segmentTree[left++];
            if (right % 2 == 1) sum += segmentTree[--right];
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}
