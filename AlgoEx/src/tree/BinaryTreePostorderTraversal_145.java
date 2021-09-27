package tree;

import java.util.*;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsPostOrder(list, root);
        return list;
    }

    private void dfsPostOrder(List<Integer> resList, TreeNode root) {
        if (root == null) {
            return;
        }
        dfsPostOrder(resList, root.left);
        dfsPostOrder(resList, root.right);
        resList.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            if (p.right != null && p.right != pre) {
                p = p.right;
                continue;
            }
            stack.pop();
            list.add(p.val);
            pre = p;
            p = null;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.addFirst(p.val);
                stack.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
         }
        return list;
    }

    public List<Integer> postorderTraversa3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        TreeNode dummy = new TreeNode(0);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.addFirst(p.val);
                stack.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }
        return list;
    }
}
