/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/3/30
 */
public class MaxChunksMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE, chunks = 0;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] > max){
                max = arr[i];
                chunks++;
            }
        }
        return chunks;
    }
}
