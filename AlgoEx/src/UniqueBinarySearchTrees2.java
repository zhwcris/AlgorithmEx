import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/9/3
 */
public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public List<TreeNode> generateTrees1(int n) {
        if(n < 1)return new ArrayList<>();
        List<TreeNode> list = generateSubTrees(1, n);
        return list;
    }

    private List<TreeNode> generateSubTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }

        if(start == end){
            TreeNode newNode = new TreeNode(start);
            list.add(newNode);
            return list;
        }
        List<TreeNode> leftSub;
        List<TreeNode> rightSub;
        for(int i = start; i <= end; i++){
            leftSub = generateSubTrees(start, i-1);
            rightSub = generateSubTrees(i+1, end);
            for(TreeNode left : leftSub){
                for (TreeNode right : rightSub){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    list.add(treeNode);
                }
            }
        }

        return list;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
