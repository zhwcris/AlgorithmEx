import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class RaceCar {
    public int racecar1(int target) {
        ArrayDeque<State> arrayDeque = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        State s0 = new State(0, 1);
        arrayDeque.offer(s0);
        set.add("0,1");
        int depth = 0;
        while (!arrayDeque.isEmpty()){
            depth++;
            int size = arrayDeque.size();
            for (int i = 0; i < size; i++) {
                State s = arrayDeque.poll();
                if(s.p == target){
                    return depth-1;
                }

                State l = new State(s.p + s.speed, s.speed * 2);
                String key = l.getKey();
                if (l.p > 0 && l.p < 2*target && !set.contains(key)) {
                    set.add(key);
                    arrayDeque.offer(l);
                }
                int speed = s.speed > 0 ? -1 : 1;
                State r = new State(s.p, speed);
                key = r.getKey();
                if(r.p > 0 && r.p < 2*target && !set.contains(key)){
                    set.add(key);
                    arrayDeque.offer(r);
                }
            }
        }
        return depth;
    }

    class State{
        int p;
        int speed;
        private State(int p, int speed){
            this.p = p;
            this.speed = speed;
        }

        String getKey(){
            return p + "," + speed;
        }
    }

    public int racecar(int target) { //top down dp
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1, dp.length, -1);
        return dfs(target, dp);
    }

    private int dfs(int i, int[] dp) {
        if (dp[i] >= 0) {
            return dp[i];
        }

        dp[i] = Integer.MAX_VALUE;

        int m = 1, j = 1;

        for (; j < i; j = (1 << ++m) - 1) {
            for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                dp[i] = Math.min(dp[i],  m + 1 + q + 1 + dfs(i - (j - p), dp));
            }
        }

        dp[i] = Math.min(dp[i], m + (i == j ? 0 : 1 + dfs(j - i, dp)));

        return dp[i];
    }
}
