package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum_112 {
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfsHasPathSum(root, targetSum);
    }

    private boolean dfsHasPathSum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        boolean resL = false, resR = false;
        if (root.left != null) {
            resL = dfsHasPathSum(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            resR = dfsHasPathSum(root.right, targetSum - root.val);
        }
        return resL || resR;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<PathTreeNode> stack = new ArrayDeque<>();
        PathTreeNode myRoot = new PathTreeNode(root, targetSum - root.val);
        stack.push(myRoot);
        while (!stack.isEmpty()) {
            PathTreeNode cur = stack.pop();
            if (cur.node.left == null && cur.node.right == null && cur.pathSum == 0) {
                return true;
            }
            if (cur.node.right != null) {
                stack.push(new PathTreeNode(cur.node.right, cur.pathSum - cur.node.right.val));
            }
            if (cur.node.left != null) {
                stack.push(new PathTreeNode(cur.node.left, cur.pathSum - cur.node.left.val));
            }
        }
        return false;
    }

    private static class PathTreeNode {
        TreeNode node;
        int pathSum;
        PathTreeNode(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }
}
