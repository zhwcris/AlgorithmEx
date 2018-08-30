import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/28
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        int high;
        for(int i = 0; i <= rowIndex; i++){
            high = i;
            rowList[high] = 1;
            high--;
            while(high > 0){
                rowList[high] = rowList[high-1] + rowList[high];
                high--;
            }
        }
        return Arrays.asList(rowList);
    }
}
