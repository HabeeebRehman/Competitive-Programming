class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q2 {
    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPath(root);
        return maxSum;
    }

    private static int findMaxPath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("Maximum Path Sum: " + maxPathSum(root)); // Output: 42
    }
}
