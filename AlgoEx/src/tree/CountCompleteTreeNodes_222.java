package tree;

public class CountCompleteTreeNodes_222 {
    /**
     * 依次检查左子树和右子树的高度，如果一直则说明测试的树是一个完美二叉树返回2^h - 1，
     * 否则就递归的获取结果 1 + countNodes(left) + countNodes(right)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getDepth(root.left, true);
        int rightH = getDepth(root.right, false);
        if (leftH == rightH) {
            return (1 << (leftH + 1)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getDepth(TreeNode root, boolean left) {
        int height = 0;
        while (root != null) {
            height++;
            if (left) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return height;
    }
}
