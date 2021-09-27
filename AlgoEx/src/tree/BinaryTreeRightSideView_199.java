package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfsRightSideView(root, list, 0);
        return list;
    }

    //[level,list]
    private void dfsRightSideView(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        dfsRightSideView(root.right, list, depth + 1);
        dfsRightSideView(root.left, list, depth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    list.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return list;
    }
}
