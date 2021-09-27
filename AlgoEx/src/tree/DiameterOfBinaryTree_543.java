package tree;

public class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    int max;
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
