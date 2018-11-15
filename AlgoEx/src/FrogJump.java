import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/15
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        boolean res = false;
        return res;
    }

    private boolean dfs(int[] stones, int steps, int index){

        int i = index + 1;
        for (; i < stones.length && stones[i] < steps - 1; i++);
        if(i == stones.length || stones[i] > steps + 1)return false;
        int[] tmp = new int[]{steps - 1, steps, steps + 1};
        for(; i < stones.length && stones[i] <= steps + 1; i++)
        return false;
    }
}
