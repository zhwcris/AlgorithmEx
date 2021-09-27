package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        if (root.right != null && root.left != null) {
            return Math.min(left, right);
        } else if (root.left == null) {
            return right;
        } else {
            return left;
        }
    }
}
