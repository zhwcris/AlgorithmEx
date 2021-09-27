package tree;

import java.util.*;

public class MaximumWidthOfBinaryTree_662 {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<MyTreeNode> queue = new ArrayDeque<>();
        queue.offer(new MyTreeNode(root, 1));
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peek().index;
            int end = queue.peekLast().index;
            max = Math.max(max, start - end + 1);
            for (int i = 0; i < size; i++) {
                MyTreeNode cur = queue.poll();
                if (cur.node.left != null) {
                    queue.offer(new MyTreeNode(cur.node.left, 2 * cur.index - 1));
                }
                if (cur.node.right != null) {
                    queue.offer(new MyTreeNode(cur.node.right, 2 * cur.index));
                }
            }
        }
        return max;
    }

    private static class MyTreeNode {
        TreeNode node;
        int index;
        public MyTreeNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    //[level,list]
    public int widthOfBinaryTree1(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
