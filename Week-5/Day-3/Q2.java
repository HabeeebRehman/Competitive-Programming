public class Q2 {
    private int[] segmentTree;
    private int n;

    public Q2(int[] nums) {
        n = nums.length;
        segmentTree = new int[2 * n];
        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = segmentTree[2 * i] + segmentTree[2 * i + 1];
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
