package tree;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SerializeAndDeserializeBST_449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfsSerialize(root, stringBuilder);
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val).append(",");
        dfsSerialize(root.left, stringBuilder);
        dfsSerialize(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Integer[] arr = Arrays.stream(data.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        return dfsDeserialize(arr, null, null);
    }

    private int index = 0;
    private TreeNode dfsDeserialize(Integer[] arr, Integer min, Integer max) {
        if (index >= arr.length) {
            return null;
        }
        if (min != null && arr[index] <= min
                || max != null && arr[index] >= max) {
            return null;
        }
        TreeNode node = new TreeNode(arr[index]);
        index++;
        node.left = dfsDeserialize(arr, min, node.val);
        node.right = dfsDeserialize(arr, node.val, max);
        return node;
    }
}
