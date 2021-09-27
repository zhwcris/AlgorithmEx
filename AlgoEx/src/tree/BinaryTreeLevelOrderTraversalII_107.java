package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> valList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resList.addFirst(valList);
        }
        return resList;
    }

    //[level,list]
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        getListOfLevels(resList, root, 0);
        Collections.reverse(resList);
        return resList;
    }

    private void getListOfLevels(List<List<Integer>> resList, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= resList.size()) {
            resList.add(new ArrayList<>());
        }
        resList.get(level).add(root.val);
        getListOfLevels(resList, root.left,level + 1);
        getListOfLevels(resList, root.right, level + 1);
    }
}
