package tree;

import java.util.*;

public class PathSumII_113 {

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        dfsFindPath(root, targetSum, new LinkedList<>());
        return resList;
    }

    private void dfsFindPath(TreeNode root, int targetSum, LinkedList<Integer> currentList) {
        if (root == null) {
            return;
        }
        currentList.addLast(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            List<Integer> path = new LinkedList<>(currentList);
            resList.add(path);
            currentList.removeLast();
            return;
        }
        dfsFindPath(root.left, targetSum - root.val, currentList);
        dfsFindPath(root.right, targetSum - root.val, currentList);
        currentList.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<Integer> currentList = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                currentList.add(cur.val);
                targetSum -= cur.val;
                pre = cur;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != pre) {
                pre = cur;
                cur = cur.right;
                continue;
            }
            if (cur.left == null && cur.right == null && targetSum == 0) {
                resList.add(new LinkedList<>(currentList));
            }
            if (!stack.isEmpty()) {
                pre = cur;
                stack.pop();
                targetSum += cur.val;
                currentList.removeLast();
                cur = null;
            }
        }
        return resList;
    }

}
