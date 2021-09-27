package tree;

public class FindBottomLeftTreeValue_513 {

    private int maxDep;
    private int target;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return target;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDep) {
            maxDep = depth;
            target = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
