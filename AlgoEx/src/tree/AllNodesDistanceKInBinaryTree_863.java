package tree;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {

    /**
     * dfs构建从root到target的路径上各个节点到target的距离map，
     * 然后从root dfs遍历root，注意超过k的深度的节点就剪枝优化掉
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> disMap = new HashMap<>();
        buildDisMap(root, target, disMap);
        List<Integer> res = new ArrayList<>();
        dfs(root, disMap.get(root), k, disMap, res);
        return res;
    }

    private void buildDisMap(TreeNode root, TreeNode target, Map<TreeNode, Integer> disMap) {
        if (root == null) {
            return;
        }
        if (root == target) {
            disMap.put(root, 0);
            return;
        }
        buildDisMap(root.left, target, disMap);
        if (disMap.containsKey(root.left)) {
            disMap.put(root, disMap.get(root.left) + 1);
            return;
        }
        buildDisMap(root.right, target, disMap);
        if (disMap.containsKey(root.right)) {
            disMap.put(root, disMap.get(root.right) + 1);
        }
    }

    private void dfs(TreeNode root, int dis, int k, Map<TreeNode, Integer> disMap, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (disMap.containsKey(root)) {
            dis = disMap.get(root);
        }
        if (dis == k) {
            res.add(root.val);
        }
        if (dis != k || !disMap.containsKey(root)) { //pruning剪枝
            dfs(root.left, dis + 1, k, disMap, res);
            dfs(root.right, dis + 1, k, disMap, res);
        }
    }
    /**
     * 先构建父子关系，然后BFS方法找深度为k的节点
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        LinkedList<TreeNode> pathToTarget = new LinkedList<>();
        dfs(root, target, pathToTarget);
        Map<Integer, TreeNode> fatherMap = new HashMap<>();
        TreeNode pre = null;
        while (!pathToTarget.isEmpty()) {
            TreeNode cur = pathToTarget.poll();
            fatherMap.put(cur.val, pre);
            pre = cur;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !fatherMap.containsKey(node.left.val)) {
                    queue.offer(node.left);
                }
                if (node.right != null && !fatherMap.containsKey(node.right.val)) {
                    queue.offer(node.right);
                }
                TreeNode father = fatherMap.get(node.val);
                if (father != null) {
                    queue.offer(father);
                }
            }
            level++;
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) res.add(queue.poll().val);
        return res;
    }

    /**
     * 找到从root到tart的路径,用来记录真个路径的父子关系
     * @param root
     * @param target
     */
    private void dfs(TreeNode root, TreeNode target, LinkedList<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (list.peekLast() == target) {
            return;
        }
        list.add(root);
        if (target == root) {
            return;
        }
        dfs(root.left, target, list);
        dfs(root.right, target, list);
        if (list.peekLast() != target) {
            list.removeLast();
        }
    }
}
