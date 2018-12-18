import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/18
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int min = Integer.MAX_VALUE;
        int[] costPrice = new int[n];
        Arrays.fill(costPrice, Integer.MAX_VALUE);
        ArrayDeque<State> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(new State(src, 0));
        int depth = 0;
        while (!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            if(depth - 1 == K)break;
            depth++;
            for (int i = 0; i < size; i++) {
                State now = arrayDeque.poll();
                for (int[] flight : flights){
                    if(flight[0] == now.stop){
                        int nowSum = now.sum + flight[2];
                        if(nowSum >= costPrice[flight[1]])continue;
                        costPrice[flight[1]] = nowSum;
                        State next = new State(flight[1], nowSum);
                        arrayDeque.offer(next);
                        if(flight[1] == dst)min = Math.min(min, nowSum);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private class State{
        private int stop;
        private int sum;

        public State(int stop, int sum){
            this.stop = stop;
            this.sum = sum;
        }
    }
}
