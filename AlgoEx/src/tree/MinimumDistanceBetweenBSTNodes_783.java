package tree;

public class MinimumDistanceBetweenBSTNodes_783 {
    private Integer pre;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
