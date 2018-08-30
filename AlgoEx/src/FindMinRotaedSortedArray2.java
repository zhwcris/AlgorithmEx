/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/5/21
 */
public class FindMinRotaedSortedArray2 {
    public int findMin(int[] nums) {
        int min = nums[0], low = 0, high = nums.length - 1, mid;
        boolean find;
        while (low <= high){
            if(high - low <= 1){
                return Math.min(nums[low], nums[high]);
            }
            mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid;
            }else if(nums[mid] < nums[high]){
                high = mid;
            }else {
                find = false;
                int i = mid;
                while (i <= high){
                    if(nums[i] < nums[mid]){
                        low = i;
                        find = true;
                        break;
                    }
                    i++;
                }
                if(!find){
                    i = mid;
                    while (i >= low){
                        if(nums[i] < nums[mid]){
                            high = i;
                            find = true;
                            break;
                        }
                        i--;
                    }
                }
                if(!find){
                    return nums[mid];
                }
            }
        }
        return min;
    }

    public int findMin2(int[] nums) {
        int min = nums[0], low = 0, high = nums.length - 1, mid;
        while (low < high){
            if(high - low == 1){
                return Math.min(nums[low], nums[high]);
            }
            mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid;
            }else if(nums[mid] < nums[high]){
                high = mid;
            }else {
                if(nums[low] == nums[mid]){
                    low++;
                    high--;
                }else {
                    high = mid;
                }
            }
        }
        return min;
    }

}
