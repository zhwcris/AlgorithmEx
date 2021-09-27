package tree;

public class FlattenBinaryTreeToLinkedList_114 {
    public void flatten2(TreeNode root) {
        dfsBuildMyList(root);
    }

    private MyList dfsBuildMyList(TreeNode root) {
        if (root == null) {
            return new MyList();
        }
        MyList left = dfsBuildMyList(root.left);
        MyList right = dfsBuildMyList(root.right);
        root.left = null;
        if (left.head == null && right.head == null) {
            return new MyList(root, root);
        }
        if (left.head == null) {
            root.right = right.head;
            return new MyList(root, right.tail);
        }
        if (right.head == null) {
            root.right = left.head;
            return new MyList(root, left.tail);
        }
        root.right = left.head;
        left.tail.right = right.head;
        return new MyList(root, right.tail);
    }

    private static class MyList {
        TreeNode head;
        TreeNode tail;
        MyList() {}
        MyList(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public void flatten(TreeNode root) {
        dfsFlatten(root, null);
        System.out.println("");
    }

    private TreeNode dfsFlatten(TreeNode root, TreeNode pre) {
        if (root == null) {
            return pre;
        }
        TreeNode right = root.right;
        if (pre != null) {
            pre.right = root;
            pre.left = null;
        }
        TreeNode leftPre = dfsFlatten(root.left, root);
        TreeNode rightPre = dfsFlatten(right, leftPre);
        return rightPre;
    }

    TreeNode pre;
    private void dfsFlatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (pre != null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        dfsFlatten(root.left);
        dfsFlatten(right);
    }
}
