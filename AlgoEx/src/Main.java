import com.sun.deploy.util.ArrayUtil;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.net.SocketTimeoutException;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws SocketTimeoutException {
        int[] test = {1};
        int[][] test1 = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        int[] test2 = {1,10,4,11};
        char[] test3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[][] test4 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Interval[] intervals = {new Interval(2,6),new Interval(1,3),new Interval(8,10),new Interval(15,18)};
        Interval[] intervals1 = {new Interval(1,4),new Interval(2,3)};
        String s = "catsanddog";
        String s1 = "ahbgdc";
        String s2 = "aabdbadc";
        String t = 12 + "-" + 1;
        s2.substring(0,0);
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = Arrays.asList(words);
        System.out.println("Integer max " + (Integer.MAX_VALUE + 1));
        Stack<Integer> tt = new Stack<>();
        tt.toArray(new Integer[2]);
        PriorityQueue<Integer> taskF = new PriorityQueue<>((a, b)-> b - a);
        taskF.offer(2);
        taskF.offer(1);
        Queue<Integer> queue = new LinkedList<>();

        WordBreak2 wordBreak2 = new WordBreak2();
        wordBreak2.wordBreak(s, wordDict);

        List list = Arrays.asList(test);

        int res = binarySearch(list, 8);

        double b = 3.72529e-9;
        System.out.println(~1);
        System.out.println(">>> :" + (-4 >> 1));
        int v = (int)Math.sqrt(256);
        System.out.println(v*v == 256);
        System.out.println(b*1000);
        System.out.println(5&4);
        System.out.println("testttt   " + (Integer.MAX_VALUE + 2));
        test();
        Object o = null;
        T pp = (T) o;

        Main main = new Main();
        main.test1();    }

    private static int binarySearch(List<Integer> list, int t){
        int low = 0, high = list.size() - 1, mid;
        while (low <= high){
            mid = (low + high) / 2;
            if(list.get(mid) <= t){
                low = mid + 1;
            }else if(list.get(mid) > t){
                high = mid - 1;
            }
        }
        return low;
    }

    private void testGeneral(){
        T tt = (T)getAttachDataByClsByNew(T.class);
    }

    public Object getAttachDataByClsByNew(Class clz) {
        Object o = null;
        try {
            o = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }

    private static void test(){
//        TreeSet<T> treeSet = new TreeSet<>(new TComparator());
//        treeSet.add(new T(3));
//        treeSet.add(new T(2));
//        treeSet.add(new T(2));
//        treeSet.add(new T(2));
//        treeSet.add(new T(1));
//        treeSet.add(new T(4));
//        System.out.println(1);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);

        for (Integer i : list){
            if(i.equals(1)){
                list.remove(i);
            }
            System.out.println("list   :" + i);
        }

    }

    private void test1(){
        Base t = new T(1);
        Inter inter = (Inter)t;
        inter.outPut("this is can be done");

        List<T> list = new ArrayList<>();
        list.add(new T(1));
        list.add(new T(2));

        List<T> list2 = new ArrayList<>();
        list2.addAll(list);

        list.remove(0);
        System.out.println("");
    }


    class T extends Base implements Inter{
        int id;

        public T(int id){
            this.id = id;
        }

        @Override
        public void outPut(String s) {
            System.out.println(s);
        }
    }

    class Base{

    }

    interface Inter{
        void outPut(String s);
    }

    class TComparator implements Comparator<T>{
        @Override
        public int compare(T o1, T o2) {
            return o1.id - o2.id >= 0 ? 1 : -1;
        }
    }


}
