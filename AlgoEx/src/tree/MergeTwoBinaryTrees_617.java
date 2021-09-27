package tree;

public class MergeTwoBinaryTrees_617 {
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        dfs(root1, root2);
        return root1;
    }

    private void dfs(TreeNode root1, TreeNode root2) {
        root1.val += root2.val;
        if (root1.left == null) {
            root1.left = root2.left;
        } else if (root2.left != null) {
            dfs(root1.left, root2.left);
        }
        if (root1.right == null) {
            root1.right = root2.right;
        } else if (root2.right != null) {
            dfs(root1.right, root2.right);
        }
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
