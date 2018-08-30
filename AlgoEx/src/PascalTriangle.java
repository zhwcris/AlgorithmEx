import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/28
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        List<Integer> lastList;
        int low, high;
        for(int i = 0; i < numRows; i++){
            Integer[] rowList = new Integer[i+1];
            rowList[0] = 1;
            rowList[i] = 1;
            low = 1;
            high = i - 1;
            while(low <= high){
                lastList = list.get(i-1);
                rowList[low] = lastList.get(low-1) + lastList.get(low);
                if(low != high){
                    rowList[high] = lastList.get(high) + lastList.get(high-1);
                }
                low++;
                high--;
            }
            list.add(Arrays.asList(rowList));
        }
        return list;
    }
}
