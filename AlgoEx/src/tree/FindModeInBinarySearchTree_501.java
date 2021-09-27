package tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree_501 {

    private Integer pre;
    private int count = 1;
    private int max;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        int cur = root.val;
        if (pre != null) {
            if (cur == pre) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(cur);
        } else if (count == max) {
            list.add(cur);
        }
        pre = cur;
        dfs(root.right, list);
    }
}
