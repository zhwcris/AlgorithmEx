import java.util.ArrayList;
import java.util.List;

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int position = Math.abs(nums[i])-1;
            nums[position] = nums[position]>0 ? -nums[position] : nums[position];
        }
        for(int i = 0; i < nums.length; i++) if(nums[i] > 0) list.add(i+1);
        return list;
    }
}
