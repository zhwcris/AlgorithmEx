package tree;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        dfsInvert(root);
        return root;
    }

    private void dfsInvert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfsInvert(root.left);
        dfsInvert(root.right);
    }
}
