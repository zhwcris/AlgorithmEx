package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> perFloorList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                perFloorList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(perFloorList);
            }
            leftToRight = !leftToRight;
            resList.add(perFloorList);
        }
        return resList;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> perFloorList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    perFloorList.add(node.val);
                } else {
                    perFloorList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            leftToRight = !leftToRight;
            resList.add(perFloorList);
        }
        return resList;
    }

    public List<List<Integer>> zigzagLevelOrde3(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Deque<TreeNode> stackLeftToRight = new ArrayDeque<>();
        Deque<TreeNode> stackRightToLeft = new ArrayDeque<>();
        stackLeftToRight.push(root);
        while (!stackLeftToRight.isEmpty() || !stackRightToLeft.isEmpty()) {
            int size1 = stackLeftToRight.size();
            int size2 = stackRightToLeft.size();
            List<Integer> perFloorList = new ArrayList<>();
            if (size1 != 0) {
                for (int i = 0; i < size1; i++) {
                    TreeNode node = stackLeftToRight.pop();
                    perFloorList.add(node.val);
                    if (node.left != null) {
                        stackRightToLeft.push(node.left);
                    }
                    if (node.right != null) {
                        stackRightToLeft.push(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size2; i++) {
                    TreeNode node = stackRightToLeft.pop();
                    perFloorList.add(node.val);
                    if (node.right != null) {
                        stackLeftToRight.push(node.right);
                    }
                    if (node.left != null) {
                        stackLeftToRight.push(node.left);
                    }
                }
            }
            resList.add(perFloorList);
        }
        return resList;
    }
}
