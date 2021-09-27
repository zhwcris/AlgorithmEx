package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum_508 {
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
               list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int sum = left + right + root.val;
        int count = map.getOrDefault(sum, 0) + 1;
        maxCount = Math.max(count, maxCount);
        map.put(sum, count);
        return sum;
    }
}
