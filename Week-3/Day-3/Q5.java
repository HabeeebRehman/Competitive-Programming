class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q5 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root = insertIntoBST(root, 2);
        root = insertIntoBST(root, 7);
        root = insertIntoBST(root, 1);
        root = insertIntoBST(root, 3);
        System.out.println(root.left.val); // Should print 2
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
