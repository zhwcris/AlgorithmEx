package tree;

import java.util.LinkedList;

public class RecoverBinarySearchTree_99 {
    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && cur.val < pre.val) {
                if (first != null) {
                    second = cur;
                }
                if (first == null) {
                    first = pre;
                    second = cur;
                }

            }
            pre = cur;
            cur = cur.right;
        }
        if (first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    public void recoverTree2(TreeNode root) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        //TreeNode t4 = new TreeNode(4);
        t1.left = t3; t3.right = t2;
        root = t1;
        dfsRecover(root);
        if (first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
        System.out.println("fff");
    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    private void dfsRecover(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfsRecover(cur.left);
        if (pre != null && cur.val < pre.val) {
            if (first == null) {
                first = pre;
                second = cur;
            } else {
                second = cur;
                return;
            }
        }
        pre = cur;
        dfsRecover(cur.right);
    }
}
