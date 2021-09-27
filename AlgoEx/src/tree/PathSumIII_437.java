package tree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII_437 {
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumFromRoot(root, targetSum) + pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum);
    }

    public int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int cur = 0;
        if (sum - root.val == 0) {
            cur++;
        }
        return cur + pathSumFromRoot(root.left, sum - root.val) +
                pathSumFromRoot(root.right, sum - root.val);
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, targetSum, 0, map);
    }

    private int dfs(TreeNode root, int targetSum, int curSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum = curSum + root.val;
        int num = map.getOrDefault(curSum - targetSum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        num += dfs(root.left, targetSum, curSum, map);
        num += dfs(root.right, targetSum, curSum, map);
        map.put(curSum, map.get(curSum) - 1);
        return num;
    }
}
