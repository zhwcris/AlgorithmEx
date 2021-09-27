package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import tree.TreeNode.MyTreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST2(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        Deque<MyTreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(0);
        MyTreeNode myTreeNode = new MyTreeNode(root, 0, nums.length - 1);
        stack.push(myTreeNode);
        while (!stack.isEmpty()) {
            myTreeNode = stack.poll();
            int mid = myTreeNode.start +  (myTreeNode.end - myTreeNode.start) / 2;
            myTreeNode.node.val = nums[mid];
            if (myTreeNode.end > mid) {
                myTreeNode.node.right = new TreeNode(0);
                stack.push(new MyTreeNode(myTreeNode.node.right, mid + 1, myTreeNode.end));
            }
            if (myTreeNode.start < mid) {
                myTreeNode.node.left = new TreeNode(0);
                stack.push(new MyTreeNode(myTreeNode.node.left, myTreeNode.start, mid - 1));
            }
        }
        return root;
    }
}
