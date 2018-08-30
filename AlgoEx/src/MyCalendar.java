import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/30
 */
public class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if(low == null || map.get(low) <= start) {
            map.put(start, end);
            return true;
        }
        return false;
    }

    public boolean book1(int start, int end) {
        assert start < end;
        Interval interval = new Interval(start, end);
        int foundIndex = Collections.binarySearch(entries, interval);
        if (foundIndex >= 0) {
            return false;
        }
        // insert and merge
        int insertPos = -(foundIndex+1);
        entries.add(insertPos, interval);
        // optionally merge
        return true;
    }

    private List<Interval> entries = new ArrayList<>();

    class Interval implements Comparable<Interval> {
        public Interval(int start, int end) {
            this.start = start;
            this.end   = end;
        }
        public int compareTo(Interval anotherInterval) {
            if (this.end <= anotherInterval.start) {
                return -1;
            } else if (this.start >= anotherInterval.end) {
                return 1;
            } else {
                return 0;       // intervals are equal so long they overlap
            }
        }

        int start;  // inclusive
        int end;    // inclusive
    }

    private TreeNode root;

    public boolean book2(int start, int end) {
        if (root == null) {
            root = insert(root, start, end);
            return true;
        }
        TreeNode result = insert(root, start ,end);
        if (result.start == -1 && result.end == -1) {
            return false;
        } else {
            root = result;
            return true;
        }
    }
    private TreeNode insert(TreeNode root, int start, int end) {
        if (root == null) {
            return new TreeNode(start, end);
        }
        if (end <= root.start) {
            TreeNode leftNode = insert(root.left, start, end);
            if (leftNode.start == -1 && leftNode.end == -1) {
                return leftNode;
            }
            root.left = leftNode;
            return root;
        }
        if (start >= root.end) {
            TreeNode rightNode = insert(root.right, start, end);
            if (rightNode.start == -1 && rightNode.end == -1) {
                return rightNode;
            }
            root.right = rightNode;
            return root;
        }
        return new TreeNode(-1, -1);
    }
    class TreeNode {
        public int start;
        public int end;
        public TreeNode left, right;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
