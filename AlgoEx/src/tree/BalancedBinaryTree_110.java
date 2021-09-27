package tree;

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = dfsHeight(root.left);
        if (lDepth == -1) {
            return -1;
        }
        int rDepth = dfsHeight(root.right);
        if (rDepth == -1) {
            return -1;
        }
        if (Math.abs(lDepth - rDepth) > 1) {
            return -1;
        }
        return Math.max(lDepth, rDepth) + 1;
    }
}
