package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator_173 {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    public BinarySearchTreeIterator_173(TreeNode root) {
        pushLeft(root);
    }

    public int next() {
        TreeNode cur = stack.pop();
        pushLeft(cur.right);
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
