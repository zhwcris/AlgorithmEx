package tree;

public class DeleteNodeInABST_450 {

    //纯非递归的方法：
    //https://leetcode.com/problems/delete-node-in-a-bst/discuss/193706/Java-Solution-(Beats-100-percent)-%3A-All-test-cases-Detailed-Explaination
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = root, parent = null;
        while (target != null && target.val != key) {
            parent = target;
            if (key < target.val) {
                target = target.left;
            } else {
                target = target.right;
            }
        }
        if (target == null) {
            return root;
        }
        if (target.left == null && target.right == null) {
            if (parent == null) return null;
            if(target==parent.left) parent.left=null;
            else parent.right=null;
            return root;
        }
        if (target.left == null) {
            if (parent == null) return target.right;
            if (target == parent.left) parent.left = target.right;
            else parent.right = target.right;
            return root;
        }
        if (target.right == null) {
            if (parent == null) return target.left; //If target node is root itself
            if (target == parent.left) parent.left = target.left;
            else parent.right = target.left;
            return root;
        }
        TreeNode prev = target, cur = target.left;
        while (cur.right != null) {
            prev = cur;
            cur = cur.right;
        }
        target.val = cur.val;
        if (cur == prev.right) {
            prev.right = cur.left;
        } else {
            prev.left = cur.left;
        }
        return root;
    }
//最初一样的想法但是写的不对
//    private TreeNode pre;
//    public TreeNode deleteNode(TreeNode root, int key) {
//        TreeNode target = findTarget(root, key);
//        if (target == null || pre == null) {
//            return root;
//        }
//        if (target.left == null && target.right == null) {
//            if (pre.left == target) {
//                pre.left = null;
//            }
//            if (pre.right == target) {
//                pre.right = null;
//            }
//            return root;
//        }
//        if (target.left == null) {
//            if (pre.left == target) {
//                pre.left = target.right;
//            }
//            if (pre.right == target) {
//                pre.right = target.right;
//            }
//            return root;
//        }
//        if (target.right == null) {
//            if (pre.left == target) {
//                pre.left = target.left;
//            }
//            if (pre.right == target) {
//                pre.right = target.left;
//            }
//            return root;
//        }
//        TreeNode cur = target.left;
//        pre = target;
//        while (cur.right != null) {
//            pre = cur;
//            cur = cur.right;
//        }
//        target.val = cur.val;
//        if (pre == target) {
//            pre.left = cur.left;
//        } else {
//            pre.right = null;
//        }
//        return root;
//    }
//
//    private TreeNode findTarget(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        while (root != null && root.val != key) {
//            pre = root;
//            if (key < root.val) {
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//        return root;
//    }
}
