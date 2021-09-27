package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class VerifyPreorderSerializationOfABinaryTree_331 {
    public boolean isValidSerialization1(String preorder) {
        int[] arr = new int[]{-1};
        String[] values = preorder.split(",");
        dfsBuild(arr, values);
        return arr[0] == values.length - 1;
    }

    private void dfsBuild(int[] arr, String[] values) {
        arr[0]++;
        if (arr[0] >= values.length) {
            return;
        }
        String value = values[arr[0]];
        if (value.equals("#")) {
            return;
        }
        dfsBuild(arr, values);
        dfsBuild(arr, values);
    }

    public boolean isValidSerialization(String preorder) {
        Deque<String> stack = new ArrayDeque<>();
        String[] values = preorder.split(",");
        int index = 0;
        String p = values[0];
        while (!stack.isEmpty() || !p.equals("#")) {
            while (!p.equals("#")) {
                stack.push(p);
                index++;
                if (index >= values.length) return false;
                p = values[index];
            }
            stack.pop();
            index++;
            if (index >= values.length) return false;
            p = values[index];
        }
        return index == values.length - 1;
    }
}
