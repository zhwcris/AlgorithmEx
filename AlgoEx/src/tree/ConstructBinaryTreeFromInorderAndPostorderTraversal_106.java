package tree;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/27
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> locCache = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            locCache.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, locCache);
    }

    private TreeNode buildTree(int[] postorder, int preS, int preE, int[] inorder, int inS, int inE, HashMap<Integer, Integer> locCache){
        if(preS > preE){
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[preE]);
        int i = locCache.get(postorder[preE]);
        treeNode.left = buildTree(postorder, preS, preS + i - inS - 1, inorder, inS, i - 1, locCache);
        treeNode.right = buildTree(postorder, preS + i - inS, preE - 1, inorder, i + 1, inE, locCache);
        return treeNode;
    }
}
