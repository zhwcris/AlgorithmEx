import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/15
 */
public class FrogJump {

    public boolean canCross(int[] stones) {//bfs slolution，这个方法应该有问题只是test case正好覆盖了，应该建立visited,来表示哪个石头是否用n jump访问过  Map<Integer, List<Integer>> seen = new HashMap<>();
        int n = stones.length;
        if(stones[1] != 1)return false;
        if(n == 2)return true;
        if(stones[n - 1] > (n * (n - 1)) / 2) return false;//别的答案的提升性能的措施
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;}//别的答案的提升性能的措施
            set.add(stones[i]);
        }
        arrayDeque.offer(new int[]{0,0});
        while (!arrayDeque.isEmpty()){
            int[] cur = arrayDeque.poll();
            int now = cur[0];
            int lastStep = cur[1];
            int next, nextStep;
            for (int i = -1; i <= 1; i++){
                nextStep = lastStep + i;
                next = now + nextStep;
                if(next == stones[n-1])return true;
                if(nextStep > 0 && set.contains(next) && next + nextStep - 1 <= stones[n-1]){
                    arrayDeque.offer(new int[]{next, nextStep});
                    set.remove(next);
                }
            }
        }
        return false;
    }
    public boolean canCross1(int[] stones) {//因为题目中表明数组的size不大 所以可以用hashset作为mem检查元素是否存在
        int n = stones.length;
        if(stones[1] != 1)return false;
        if(n == 2)return true;
        // the most progressive arrange is [0, 1, 3, 6, 10, 15, 21, ...]
        // the right-most point is at most 0 + (1 + len - 1) * (len - 1) / 2
        if(stones[n - 1] > (n * (n - 1)) / 2) return false;//别的答案提醒的提升性能的trick
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();//记录可以某个石头可以跳出的steps eg:  [2,[3,4,5]]  表示石头2可以跳出3,4,5的跳数
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;}//别的答案的提升性能的措施
            map.put(stones[i], new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            int now = stones[i];
            HashSet<Integer> set = map.get(now);
            for (Integer step : set){
                int reach = now + step;
                if(reach == stones[n-1])return true;
                HashSet<Integer> reachSet = map.get(reach);
                if(reachSet != null){
                    if(step > 1)reachSet.add(step - 1);
                    reachSet.add(step);
                    reachSet.add(step + 1);
                }
            }
        }
        return false;
    }

    private boolean dfs(HashSet<Integer> set, int steps, int now, int last){//可以加入memo，hashset记录第i个石头多少jump是否成功的结果
        if(now == last)return true;

        if(set.contains(now + steps + 1) && dfs(set, steps + 1, now + steps + 1, last)){
            return true;
        }
        if(steps > 1 && set.contains(now + steps - 1) && dfs(set, steps - 1, now + steps - 1, last)){
            return true;
        }
        if(set.contains(now + steps) && dfs(set, steps, now + steps, last)){
            return true;
        }
        return false;
    }
}
