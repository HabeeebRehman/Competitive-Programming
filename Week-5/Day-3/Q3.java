public class Q3 {
    private int[] tree;
    private int n;

    public Q3(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int index, int delta) {
        while (index <= n) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}
