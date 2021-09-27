package tree;

public class ConvertSortedListToBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        return dfsBuildTree(head, null);
    }

    private TreeNode dfsBuildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head,fast = head;//fast初始化head或head.next都可以
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = dfsBuildTree(head, slow);
        node.right = dfsBuildTree(slow.next, tail);
        return node;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
