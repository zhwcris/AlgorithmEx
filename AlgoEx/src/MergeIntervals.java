/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/6/29
 */


import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comparator);
        int n = intervals.size();
        Interval last, now;
        for (int i = 0; i < n; i++) {
            last = intervals.get(i);
            result.add(last);
            while (i < n){
                i++;
                if(i >= n)break;
                now = intervals.get(i);
                if(now.start > last.end){
                    i--;
                    break;
                }else {
                    last.end = Math.max(last.end, now.end);
                }
            }
        }
        return result;
    }
}
