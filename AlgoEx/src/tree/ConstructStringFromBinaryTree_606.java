package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructStringFromBinaryTree_606 {
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.substring(1);
    }

    private void dfs(TreeNode root, StringBuilder stringBuilder) {
        stringBuilder.append("(").append(root.val);
        if (root.left != null) {
            dfs(root.left, stringBuilder);
            stringBuilder.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                stringBuilder.append("()");
            }
            dfs(root.right, stringBuilder);
            stringBuilder.append(")");
        }
    }


    //https://leetcode.com/problems/construct-string-from-binary-tree/discuss/314882/Java-Iterative-without-'visited'-set
    //每一个节点入栈之前都插入一个哨兵节点，标识已经遍历完所有子树回到一个节点，需要增加")"
    public String tree2str1(TreeNode t) {
        if (t == null)
            return "";
        TreeNode dummy = new TreeNode(0);
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(t);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node == dummy) {
                sb.append(')');
                continue;
            }
            sb.append('(').append(node.val);
            s.push(dummy);
            if (node.left == null && node.right != null)
                sb.append("()");
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }
        return sb.substring(1, sb.length() - 1);
    }
}
