package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsPreorder(list, root);
        return list;
    }

    private void dfsPreorder(List<Integer> resList, TreeNode root) {
        if (root == null) {
            return;
        }
        resList.add(root.val);
        dfsPreorder(resList, root.left);
        dfsPreorder(resList, root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {  //非递归遍历方法1
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return list;
    }

    public List<Integer> preorderTraversal3(TreeNode root) {  //非递归遍历方法2
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                list.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {  //非递归遍历方法3
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            list.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return list;
    }
}
