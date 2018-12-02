import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {//此种方法尝试所有的可能，故visited会在尝试失败的时候回溯到初始值
        int sum = 0;
        for(int num:nums)sum += num;
        if(k <= 0 || sum%k != 0)return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }

    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
        if(k==1)return true;
        if(cur_sum == target && cur_num>0)return canPartition(nums, visited, 0, k-1, 0, 0, target);
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))return true;
                visited[i] = 0;
            }
        }
        return false;
    }


    public boolean canPartitionKSubsets1(int[] nums, int k) {//sort 从大到小的去取值  达到剪支的目的，防止大数没有与小数组合的机会
        int n = nums.length, sum = 0;
        for (int x : nums)sum += x;
        if(sum % k != 0)return false;
        int target = sum / k;
        Arrays.sort(nums);
        boolean[] used = new boolean[n];
        while (k > 0 && dfs(nums, target, used, n-1))k--;
        return k == 0;
    }

    private boolean dfs(int[] nums, int target, boolean[] used, int index){//是否能找到一个子集合sum = target,并且used标记为true
        if(target == 0)return true;
        if(target < 0)return false;
        for (int i = index; i >= 0; i--) {
            if(used[i] == true)continue;;
            used[i] = true;
            if(dfs(nums, target - nums[i], used, i-1)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}
