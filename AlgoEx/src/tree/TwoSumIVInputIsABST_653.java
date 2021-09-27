package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIVInputIsABST_653 {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    private boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null) {
            return false;
        }
        if (searchTarget(root, cur, k - cur.val)) {
            return true;
        }
        return dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    private boolean searchTarget(TreeNode root, TreeNode cur, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value && root != cur) {
            return true;
        }
        if (root.val > value) {
            return searchTarget(root.left, cur, value);
        }
        if (root.val < value) {
            return searchTarget(root.right, cur, value);
        }
        return false;
    }

    //Method1
    public boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    //Method2
    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;) {
            int sum = nums.get(i) + nums.get(j);
            if(sum == k)return true;
            if(sum < k)i++;
            else j--;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
