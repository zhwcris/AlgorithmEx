import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/7/31
 */
public class MyCalendarTwo {
    public MyCalendarTwo() {
    }

    private List<int[]> books = new ArrayList<>();
    MyCalendar myCalendar = new MyCalendar();
    public boolean book(int start, int end) {
        myCalendar.clear();
        Iterator<int[]> iterator = books.iterator();
        while (iterator.hasNext()){
            int[] time = iterator.next();
            int overLapS = Math.max(time[0], start);
            int overLapE = Math.min(time[1], end);
            if(Math.max(time[0], start) < Math.min(time[1], end)){
                if(!myCalendar.book(overLapS, overLapE))return false;
            }
        }
        books.add(new int[]{start, end});
        return true;
    }

    private class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer low = map.lowerKey(end);

            if (low == null || map.get(low) <= start) {
                map.put(start, end);
                return true;
            }
            return false;
        }

        public void clear(){
            map.clear();
        }
    }

    TreeNode root;

    public boolean book1(int start, int end) {
        if(!insertable(start, end, root)){
            return false;
        }
        root = insert(start, end, root);
        return true;
    }

    private class TreeNode{
        int start;
        int end;
        boolean overLap;
        TreeNode left;
        TreeNode right;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    private TreeNode insert(int start, int end, TreeNode root){
        if(root == null){
            return new TreeNode(start, end);
        }
        if(end <= root.start){
            root.left = insert(start, end, root.left);
            return root;
        }else if(start >= root.end){
            root.right = insert(start, end, root.right);
            return root;
        }else {
            root.overLap = true;
            int rootS = Math.max(start, root.start);
            int rootE = Math.min(end, root.end);
            int frontS = Math.min(start, root.start);
            int backE = Math.max(end, root.end);
            if(frontS < rootS){
                root.left = insert(frontS, rootS, root.left);
            }
            if(rootE < backE){
                root.right = insert(rootE, backE, root.right);
            }
            root.start = rootS;
            root.end = rootE;
            return root;
        }
    }

    private boolean insertable(int start, int end, TreeNode cur) {
        if (start >= end) return true;
        if (cur == null) return true;
        if (start >= cur.end) { // check right side
            return insertable(start, end, cur.right);
        } else if (end <= cur.start) { // check left side
            return insertable(start, end, cur.left);
        } else { // intersect
            if (cur.overLap) { // cur node's overlap is true
                return false;
            } else { // cur node overlap is false
                if (start >= cur.start && end <= cur.end) { // inside
                    return true;
                } else { // check left and right
                    return insertable(start, cur.start, cur.left) && insertable(cur.end, end, cur.right);
                }
            }
        }
    }

    public boolean book2(int start, int end) {//该方法不可以解决新的Interval同时覆盖两个以上的interval
        Interval interval = new Interval(start, end);
        int foundIndex = Collections.binarySearch(entries, interval);
        if (foundIndex >= 0) {
            Interval found = entries.get(foundIndex);
            if(found.overLap){
                return false;
            }else {
                found.overLap = true;
                int foundS = Math.max(start, found.start);
                int foundE = Math.min(end, found.end);
                int frontS = Math.min(start, found.start);
                int backE = Math.max(end, found.end);
                found.start = Math.max(start, foundS);
                found.end = Math.min(end, foundE);
                if(backE != foundE){
                    Interval back = new Interval(foundE, backE);
                    entries.add(foundIndex+1, back);
                }
                if(frontS != foundS){
                    Interval front = new Interval(frontS, foundS);
                    entries.add(foundIndex, front);
                }

                return true;
            }
        }
        // insert and merge
        int insertPos = -(foundIndex+1);
        entries.add(insertPos, interval);
        //entries.add();
        // optionally merge
        return true;
    }

    private List<Interval> entries = new ArrayList<>();

    private class Interval implements Comparable<Interval> {
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
        boolean overLap = false;
        int start;  // inclusive
        int end;    // inclusive
    }
}
