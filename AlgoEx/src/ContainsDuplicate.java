import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Byte> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) != null){
                return true;
            }else map.put(nums[i], (byte) 0x01);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }
}
