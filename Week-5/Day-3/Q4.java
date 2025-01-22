public class Q4 {
    private int[] tree;
    private int n;

    public Q4(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int index, int val) {
        int diff = val - query(index, index);
        while (index <= n) {
            tree[index] += diff;
            index += index & -index;
        }
    }

    public int query(int left, int right) {
        return sum(right) - sum(left - 1);
    }

    private int sum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
