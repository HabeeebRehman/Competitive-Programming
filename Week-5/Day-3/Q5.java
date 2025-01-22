public class Q5 {
    private int[] tree;
    private int n;

    public Q5(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
        }
    }

    public void update(int index, int val) {
        tree[n + index] = val;
        index += n;
        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
        }
    }

    public int maxRange(int left, int right) {
        int max = Integer.MIN_VALUE;
        left += n;
        right += n + 1;
        while (left < right) {
            if (left % 2 == 1) max = Math.max(max, tree[left++]);
            if (right % 2 == 1) max = Math.max(max, tree[--right]);
            left /= 2;
            right /= 2;
        }
        return max;
    }
}
