package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode getTree() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t3.left = t9; t3.right = t20; t20.left = t15; t20.right = t7;
        return t3;
    }

    public static TreeNode getTree2() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t5.left = t3; t5.right = t6; t3.left = t2; t3.right = t4; t6.right = t7;
        return t5;
    }

    public static TreeNode getTmpTree() {

        TreeNode t4 = new TreeNode(0);
        TreeNode t6 = new TreeNode(0);
        TreeNode t5 = new TreeNode(0, null, t6);
        TreeNode t2 = new TreeNode(0, t4, null);
        TreeNode t3 = new TreeNode(0, null, t5);
        TreeNode t1 = new TreeNode(0, t2, t3);
        return t1;
    }

    public static class MyTreeNode {
        TreeNode node;
        int start;
        int end;
        public MyTreeNode(TreeNode node, int start, int end) {
            this.node = node;
            this.start = start;
            this.end = end;
        }
    }
}