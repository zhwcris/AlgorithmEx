package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class TrimABinarySearchTree_669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        while (newRoot != null && (newRoot.val < low || newRoot.val > high)) { //找到新的根节点在区间内
            if (newRoot.val < low) {
                newRoot = newRoot.right;
            }
            if (newRoot.val > high) {
                newRoot = newRoot.left;
            }
        }
        if (newRoot == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(newRoot);
        boolean childChanged = false;//节点的子节点被调整过
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
                childChanged = true;
            }
            if (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
                childChanged = true;
            }
            if (!childChanged) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                stack.push(cur);//当前节点的子节点被调整过，仍需继续判断是否调整新的子节点。
            }
            childChanged = false;
        }
        return newRoot;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        while (newRoot != null && (newRoot.val < low || newRoot.val > high)) { //找到新的根节点在区间内
            if (newRoot.val < low) {
                newRoot = newRoot.right;
            }
            if (newRoot.val > high) {
                newRoot = newRoot.left;
            }
        }
        //将左侧子树小于low的节点trim掉
        TreeNode cur = newRoot;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = newRoot;
        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return newRoot;
    }

    public TreeNode trimBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
