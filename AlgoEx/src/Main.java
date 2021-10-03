import tree.*;
import tree.TreeNode;

import java.io.File;
import java.net.SocketTimeoutException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SocketTimeoutException, IllegalAccessException, InstantiationException {
        int[] test = {1,2,3,4,5,6,7};
        int shift = (5 - 1) >> 1;
        String s = "babad";
        String s1 = "leet";
        String s2 = "aabdbadc";
        TreeNode root = TreeNode.getTmpTree();
        int[] preorder = {0,1,2,3,4,5};
        int testI = Integer.parseInt("046");
        Integer[] arrff = Arrays.stream(new String[] {"7","4","2","3","6","5","9","8","10"})
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int[][] test1 = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        SumOfDistancesInTree_834 sumOfDistancesInTree = new SumOfDistancesInTree_834();
        sumOfDistancesInTree.sumOfDistancesInTree(6, test1);
        s2.substring(0,0);
        String[] words = {"control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"};
        int b1 = 1, b2 = 2;
        int bit = b1 << 2;
        List<String> wordDict = Arrays.asList(words);
        //wordDict.set(0, "ssss");
        System.out.println("Integer max " + (Integer.MAX_VALUE + 1));
        Stack<Integer> tt = new Stack<>();
        tt.toArray(new Integer[2]);
        PriorityQueue<Integer> taskF = new PriorityQueue<>((a, b)-> a - b);
        taskF.offer(2);
        taskF.offer(1);
        Queue<Integer> queue = new LinkedList<>();
        boolean b = false;

        File f = new File(Main.class.getResource("/").getPath());
        System.out.println(f);

        String stt = transferHash(test);
        b = s.contains("0");
        Arrays.sort(test1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    private static String transferHash(int[] count){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            s.append((char)(i + 'a')).append(count[i]);
        }
        return s.toString();
    }

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
