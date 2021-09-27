package tree;

public class PopulatingNextRightPointersInEachNode_116 {
    public Node connect1(Node root) {
        if (root == null) return null;
        Node levelHead = root;
        Node cur = levelHead;
        while (levelHead.left != null) {
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelHead = levelHead.left;
            cur = levelHead;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) return null;
        dfsConnect(root);
        return root;
    }

    private void dfsConnect(Node root) {
        if (root == null) return;
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        dfsConnect(root.left);
        dfsConnect(root.right);
    }


}
