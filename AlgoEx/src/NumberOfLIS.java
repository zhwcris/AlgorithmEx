public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int n = nums.length, maxLen = 0, maxNum = 0;
        int[]len = new int[n];//the length of the LIS ends with i
        int[]num = new int[n];//the num of the LIS ends with i
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            num[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] <= nums[j])continue;
                if(len[j] + 1 > len[i]){
                    len[i] = len[j] + 1;
                    num[i] = num[j];
                }else if(len[j] + 1 == len[i]){
                    num[i] += num[j];
                }
            }
            if(len[i] > maxLen){
                maxLen = len[i];
                maxNum = num[i];
            }else if(len[i] == maxLen){
                maxNum += num[i];
            }
        }
        return maxNum;
    }
}
