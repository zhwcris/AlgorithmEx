package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths_257 {
    private List<String> resList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfsGetPath(root, new LinkedList<>());
        return resList;
    }

    private void dfsGetPath(TreeNode root, LinkedList<Integer> currentList) {
        if (root == null) {
            return;
        }
        currentList.addLast(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder strBuilder = new StringBuilder();
            currentList.forEach(x -> strBuilder.append(x).append("->"));
            strBuilder.delete(strBuilder.length() - 2, strBuilder.length());
            resList.add(strBuilder.toString());
        }
        dfsGetPath(root.left, currentList);
        dfsGetPath(root.right, currentList);
        currentList.removeLast();
    }
}
