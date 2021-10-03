package tree;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode target = root;
        if (root.val < val) {
            target = searchBST(root.right, val);
        } else if (root.val > val) {
            target = searchBST(root.left, val);
        }
        return target;
    }
}
