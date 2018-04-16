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
}
