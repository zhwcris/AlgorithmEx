package tree;

import java.util.Arrays;

public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = dfs(nums, left, max - 1);
        node.right = dfs(nums, max + 1, right);
        return node;
    }
}
