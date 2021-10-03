package tree;

public class SmallestSubtreeWithAllTheDeepestNodes_865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int h = dfsMaxDepth(root);
        return dfs(root, 1, h);
    }

    private TreeNode dfs(TreeNode root, int level, int h) {
        if (root == null) {
            return null;
        }
        if (level == h) {
            return root;
        }
        TreeNode left = dfs(root.left, level + 1, h);
        TreeNode right = dfs(root.right, level + 1, h);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    private int dfsMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfsMaxDepth(root.left);
        int right = dfsMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
