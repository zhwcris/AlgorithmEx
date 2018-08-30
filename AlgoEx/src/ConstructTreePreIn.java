/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/27
 */

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

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class ConstructTreePreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE){
        if(preS > preE){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preS]);
        int i;
        for (i = inS; i <= inE; i++){
            if(inorder[i] == preorder[preS])break;
        }
        treeNode.left = buildTree(preorder, preS + 1, preS + i - inS, inorder, inS, i - 1);
        treeNode.right = buildTree(preorder, preS + i - inS + 1, preE, inorder, i + 1, inE);
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
}
