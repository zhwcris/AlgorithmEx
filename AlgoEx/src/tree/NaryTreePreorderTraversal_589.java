package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NaryTreePreorderTraversal_589 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return list;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resList.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return resList;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
