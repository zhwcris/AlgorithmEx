package tree;

public class KthSmallestElementInBST_230 {
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[1];
        TreeNode resNode = new TreeNode();
        dfsKth(root, k, resNode);
        return resNode.left.val;
    }

    private void dfsKth(TreeNode root, int k, TreeNode resNode) {
        if (root == null) {
            return;
        }
        dfsKth(root.left, k, resNode);
        resNode.val++;
        if (resNode.val == k) {
            resNode.left = root;
            return;
        }
        dfsKth(root.right, k, resNode);
    }

    /**当二叉树拼房被访问计算第k个大小的时候，可以构造一棵树，每个节点都存储它的孩子数目，方便计算第K个节点的位置
     * 另一种方法
     */

    public class tTreeNode {
        int val;
        int count;
        tTreeNode left;
        tTreeNode right;
        tTreeNode(int x) { val = x; count = 1;}
    }

    class Solution {
        tTreeNode tRoot;
        public int kthSmallest(TreeNode root, int k) {
            tRoot = buildtTree(root);
            return helper(tRoot, k);
        }

        public Integer helper(tTreeNode tRoot, int k){
            int leftCount = (tRoot.left == null)? 0 : tRoot.left.count;
            if(k == leftCount + 1) return tRoot.val;
            else if (k > leftCount + 1) return helper(tRoot.right, k - leftCount - 1);
            else return helper(tRoot.left, k);
        }

        public tTreeNode buildtTree(TreeNode root){
            if(root == null) return null;
            tTreeNode tNode = new tTreeNode(root.val);
            tNode.left = buildtTree(root.left);
            tNode.right = buildtTree(root.right);
            tNode.count +=  (tNode.left == null)? 0 : tNode.left.count;
            tNode.count +=  (tNode.right == null)? 0 : tNode.right.count;
            return tNode;
        }
    }
}
