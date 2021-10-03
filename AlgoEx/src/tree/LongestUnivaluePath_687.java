package tree;

public class LongestUnivaluePath_687 {
    private int max;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            left++;
        } else {
            left = 0;
        }
        if (root.right != null && root.val == root.right.val) {
            right++;
        } else {
            right = 0;
        }
        this.max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
