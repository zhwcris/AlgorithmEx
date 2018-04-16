import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/13
 */
public class MaxChunksMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int count = 0, upperLimit = Integer.MAX_VALUE;
        int[] max = new int[arr.length];
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        max[0] = arr[0];
        for (int i = 1; i < max.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if(max[i] == sorted[i]){
                if(max[i] > upperLimit)continue;
                count++;
                upperLimit = arr[i];
            }
        }
        return count;
    }

    public int maxChunksToSorted1(int[] arr) {
        int count = 0, sum = 0, sum1 = 0;
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        Arrays.sort(sorted);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum1 += sorted[i];
            if(sum == sum1)count++;
        }
        return count;
    }

    public int maxChunksToSorted2(int[] arr) {
        int count = 0, len = arr.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = arr[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        min[len-1] = arr[len-1];
        for(int i = len - 2; i >= 0; i--){
            min[i] = Math.min(min[i+1], arr[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            if(max[i] <= min[i+1]){
                count++;
            }
        }
        return count+1;
    }
}
