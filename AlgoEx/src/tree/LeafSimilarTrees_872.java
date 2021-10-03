package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeafSimilarTrees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && stack2.isEmpty()) {
            int val1 = getNextLeaf(stack1);
            int val2 = getNextLeaf(stack2);
            if (val1 != val2) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int getNextLeaf(Deque<TreeNode> stack) {
        while (true) {
            TreeNode p = stack.pop();
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.left == null && p.right == null) {
                return p.val;
            }
        }
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        dfs(root1, builder1);
        dfs(root2, builder2);
        return builder1.toString().equals(builder2.toString());
    }

    private void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            builder.append(root.val).append(",");
        }
        dfs(root.left, builder);
        dfs(root.right, builder);
    }
}
