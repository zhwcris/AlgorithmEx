package tree;

import java.util.*;

public class NaryTreePostorderTraversal_590 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder1(Node root) {
        if (root == null) {
            return list;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        list.add(root.val);
        return list;
    }

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return list;
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
