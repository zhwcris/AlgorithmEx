import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int position;
        for(int i = 0; i < nums.length; i++){
            position = Math.abs(nums[i]) -1;
            if(nums[position] < 0){
                list.add(Math.abs(nums[i]));
            }else {
                nums[position] = -nums[position];
            }
        }
        return  list;
    }
}
