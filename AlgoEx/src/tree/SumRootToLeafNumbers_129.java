package tree;

public class SumRootToLeafNumbers_129 {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfsSumNumbers(root, 0);
        return sum;
    }

    private void dfsSumNumbers(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
            return;
        }
        dfsSumNumbers(root.left, curSum);
        dfsSumNumbers(root.right, curSum);
    }
}
