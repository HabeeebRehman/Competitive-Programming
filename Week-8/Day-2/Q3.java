public class Q3 {
    private int[] tree, lazy;
    private int n;

    public Q3(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = (start + end) / 2;
            build(nums, 2 * node + 1, start, mid);
            build(nums, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    private void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    public void updateRange(int l, int r, int val) {
        updateRange(0, 0, n - 1, l, r, val);
    }

    private void updateRange(int node, int start, int end, int l, int r, int val) {
        propagate(node, start, end);
        if (r < start || l > end) return;
        if (l <= start && end <= r) {
            tree[node] += (end - start + 1) * val;
            if (start != end) {
                lazy[2 * node + 1] += val;
                lazy[2 * node + 2] += val;
            }
            return;
        }
        int mid = (start + end) / 2;
        updateRange(2 * node + 1, start, mid, l, r, val);
        updateRange(2 * node + 2, mid + 1, end, l, r, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r) {
        propagate(node, start, end);
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);
        return left + right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        Q3 st = new Q3(nums);
        System.out.println("Sum of range [1, 3]: " + st.query(1, 3)); 
        st.updateRange(1, 3, 10);
        System.out.println("Sum of range [1, 3] after range update: " + st.query(1, 3)); 
    }
}
