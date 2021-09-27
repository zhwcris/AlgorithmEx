package tree; /**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/27
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        return buildTree3(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree3(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS > preE){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preS]);
        int i;
        for (i = inS; i <= inE; i++){
            if(inorder[i] == preorder[preS])break;
        }
        treeNode.left = buildTree3(preorder, preS + 1, preS + i - inS, inorder, inS, i - 1);
        treeNode.right = buildTree3(preorder, preS + i - inS + 1, preE, inorder, i + 1, inE);
        return treeNode;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> locCache = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){

            locCache.put(inorder[i], i);
        }
        return buildTree1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, locCache);
    }

    private TreeNode buildTree1(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE, HashMap<Integer, Integer> locCache){
        if(preS > preE){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preS]);
        int i = locCache.get(preorder[preS]);
        treeNode.left = buildTree1(preorder, preS + 1, preS + i - inS, inorder, inS, i - 1, locCache);
        treeNode.right = buildTree1(preorder, preS + i - inS + 1, preE, inorder, i + 1, inE, locCache);
        return treeNode;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        stack.push(root);
        int i = 1, j=0;
        boolean back = false;
        while(i < preorder.length){
            if(!stack.isEmpty() && stack.peek().val == inorder[j]){
                cur = stack.pop();
                back = true;
                j++;
            }else {
                if(back == false){
                    cur.left = new TreeNode(preorder[i]);
                    cur = cur.left;
                    stack.push(cur);
                    i++;
                }else {
                    cur.right = new TreeNode(preorder[i]);
                    cur = cur.right;
                    stack.push(cur);
                    i++;
                }
            }
        }
        return root;
    }

    /**
     * 2021/09/04
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree4(int[] preorder, int[] inorder) {
        return buildTree4(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree4(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) break;
        }
        int leftLen = i - inStart;
        TreeNode cur = new TreeNode(preorder[preStart]);
        cur.left = buildTree4(preorder, preStart + 1, preStart + leftLen, inorder, inStart, i - 1);
        cur.right = buildTree4(preorder, preStart + leftLen + 1, preEnd, inorder, i + 1, inEnd);
        return cur;
    }

    public TreeNode buildTree24(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        stack.push(cur);
        int i = 1, j = 0;
        boolean back = false;
        while (i < preorder.length) {
            if (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                cur = stack.pop();
                back = true;
                j++;
            } else {
                TreeNode node = new TreeNode(preorder[i]);
                if (back) {
                    cur.right = node;
                } else {
                    cur.left = node;
                }
                cur = node;
                stack.push(node);
                back = false;
                i++;
            }
        }
        return root;
    }
}
