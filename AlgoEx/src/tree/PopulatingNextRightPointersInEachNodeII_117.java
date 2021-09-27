package tree;

public class PopulatingNextRightPointersInEachNodeII_117 {
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;    //上层的当前节点
        Node nextLevelHead = null;  //下一层的头结点
        Node nextCur = null;   //下一层的当前节点
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (nextCur != null) {
                        nextCur.next = cur.left;
                    } else {
                        nextLevelHead = cur.left;
                    }
                    nextCur = cur.left;
                }
                if (cur.right != null) {
                    if (nextCur != null) {
                        nextCur.next = cur.right;
                    } else {
                        nextLevelHead = cur.right;
                    }
                    nextCur = cur.right;
                }
                cur = cur.next;
            }
            cur = nextLevelHead;
            nextCur = null;
            nextLevelHead = null;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;    //上层的当前节点
        Node nextDummyHead = new Node(0);  //下一层的哨兵头结点
        Node nextCur = nextDummyHead;   //下一层的当前节点
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    nextCur.next = cur.left;
                    nextCur = cur.left;
                }
                if (cur.right != null) {
                    nextCur.next = cur.right;
                    nextCur = cur.right;
                }
                cur = cur.next;
            }
            cur = nextDummyHead.next;
            nextDummyHead.next = null;
            nextCur = nextDummyHead;
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root);
        }
        connect(root.right);   //从有开始先连接，这样左面的节点就可以从处理链表头部
        connect(root.left);
        return root;
    }

    private Node findNext(Node cur) {
        while (cur.next != null) {
            cur = cur.next;
            if (cur.left != null) {
                return cur.left;
            }
            if (cur.right != null) {
                return cur.right;
            }
        }
        return null;
    }
}
