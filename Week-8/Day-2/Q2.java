public class Q2 {
    private int[] tree;
    private int n;

    public Q2(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public void update(int index, int val) {
        for (int i = index + 1; i <= n; i += i & (-i)) {
            tree[i] += val;
        }
    }

    public int query(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Q2 fenwickTree = new Q2(6);
        fenwickTree.update(0, 1);
        fenwickTree.update(1, 3);
        fenwickTree.update(2, 5);
        System.out.println("Sum of first 3 elements: " + fenwickTree.query(2)); // Output: 9
        fenwickTree.update(1, 2);
        System.out.println("Sum of first 3 elements after update: " + fenwickTree.query(2)); // Output: 11
    }
}
