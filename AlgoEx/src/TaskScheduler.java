import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/28
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int least = 0;
        int[] chars = new int[26];
        for (int c : tasks){
            chars[c - 'A']++;
        }
        Arrays.sort(chars);
        int i = 25;
        while (i >= 0 && chars[i] == chars[25])i--;
        least = (chars[25] - 1) * (n + 1) + 25 - i;
        return Math.max(tasks.length, least);
    }

    public int leastInterval1(char[] tasks, int n) {
        int least = 0;
        int[] chars = new int[26];
        int maxFrequency = 0;
        int countOfMax = 0;
        int loc;
        for (int c : tasks){
            loc = c - 'A';
            chars[loc]++;
            if(chars[loc] > maxFrequency){
                maxFrequency = chars[loc];
                countOfMax = 1;
            }else if(chars[loc] == maxFrequency){
                countOfMax++;
            }
        }

        int slots = (maxFrequency - 1) * (n - (countOfMax - 1));
        int otherTasks = tasks.length - maxFrequency * countOfMax;
        int idles = Math.max(0, slots - otherTasks);

        least = tasks.length + idles;

        return least;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] chars = new int[26];
        for (int c : tasks){
            chars[c - 'A']++;
        }

        PriorityQueue<Integer> taskF = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int c : chars){
            if(c > 0){
                taskF.offer(c);
            }
        }

        int i = 0, interVals = 0, value;
        ArrayList<Integer> frequencyList = new ArrayList<>();
        while (!taskF.isEmpty()){
            while(i <= n){
                if(!taskF.isEmpty()){
                    value = taskF.peek() - 1;
                    if(value > 0){
                        frequencyList.add(value);
                    }
                    taskF.poll();
                }
                interVals++;
                if(taskF.isEmpty() && frequencyList.size() == 0){
                    break;
                }
                i++;
            }

            for(int v : frequencyList){
                taskF.offer(v);
            }
            frequencyList.clear();
            i = 0;
        }

        return interVals;
    }
}
