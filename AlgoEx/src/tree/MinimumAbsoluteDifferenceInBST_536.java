package tree;

public class MinimumAbsoluteDifferenceInBST_536 {

    private Integer pre;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null && pre != root.val) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
