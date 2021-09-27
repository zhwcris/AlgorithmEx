package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(new HashMap<>(), root, list);
        return list;
    }

    private String dfs(Map<String, Integer> map, TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return "#";
        }
        String left = dfs(map, root.left, list);
        String right = dfs(map, root.right, list);
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(root.val).append(",").append(left).append(",").append(right);
        String str = strBuilder.toString();
        int count = map.getOrDefault(str, 0);
        map.put(str, count + 1);
        if (count + 1 == 2) {
            list.add(root);
        }
        return str;
    }

    /**
     * 更快的答案，利用序列化的顺序ID：
     * https://blog.csdn.net/level_code/article/details/111187010
     *
     * https://leetcode.com/problems/find-duplicate-subtrees/discuss/112442/C%2B%2B-15ms-(less-99.76)
     */
}
