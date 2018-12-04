/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/4
 */
public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {

    }

    private int dfs(int[] boxed, int start, int end, int k, int len){

        int res = 0;
        for (int i = start; i <= end; i++) {
            int j = start;
            while (j <= end && boxed[i] == boxed[j])j++;
            
        }
    }
}
