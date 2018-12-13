import java.util.*;

public class KeysKeyboard2 {
    public int minSteps1(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                if(i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

    class Stat {
        int currLen;
        int clipLen;
        public Stat (int a, int b) {
            currLen = a; clipLen = b;
        }
    }

    public int minSteps11(int n) {//bfs的另一种写法
        if (n == 1) return 0;

        int step = 1;
        Queue<Stat> queue = new LinkedList<>();
        queue.add(new Stat(1, 1));
        Set<String> set = new HashSet<>();
        set.add("1,1");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Stat s = queue.poll();
                // Copy All
                if (!set.contains(s.currLen + "," + s.currLen)) {
                    queue.add(new Stat(s.currLen, s.currLen));
                    set.add(s.currLen + "," + s.currLen);
                }
                // Paste
                if (s.currLen + s.clipLen == n) return step;
                if (!set.contains((s.currLen + s.clipLen) + "," + s.clipLen) && s.currLen + s.clipLen < n) {
                    queue.add(new Stat(s.currLen + s.clipLen, s.clipLen));
                    set.add((s.currLen + s.clipLen) + "," + s.clipLen);
                }
            }
        }

        return -1;
    }

    public int minSteps2(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }

    public int minSteps(int n) {//bfs solution
        if(n == 1)return 0;
        if(n == 2)return 2;
        State start = new State(1, 2);
        int depth = 1;
        ArrayDeque<State> arrayDeque = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        arrayDeque.offer(start);
        set.add("1_2");
        int perFloor = 1, tmp = 0;
        while (!arrayDeque.isEmpty()){
            if(perFloor == 0){
                depth++;
                perFloor = tmp;
                tmp = 0;
            }
            State now = arrayDeque.poll();
            perFloor--;
            if(now.paste + now.length == n)return depth + 2;
            //paste
            if(!set.contains(now.paste + "_" + (now.paste + now.length)) && now.paste + now.length < n){
                State p = new State(now.paste, now.paste + now.length);
                arrayDeque.offer(p);
                set.add(now.paste + "_" + (now.paste + now.length));
                tmp++;
            }
            //copy
            if(!set.contains(now.length + "_" + now.length)){
                State p = new State(now.length, now.length);
                arrayDeque.offer(p);
                set.add(now.length + "_" + now.length);
                tmp++;
            }
        }
        return depth + 2;
    }

    class State{
        int paste;
        int length;
        public State(int paste, int length){
            this.paste = paste;
            this.length = length;
        }
    }
}
