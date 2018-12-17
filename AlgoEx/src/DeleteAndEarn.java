public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int pre2 = 0, pre1 = 0, cur = 0;
        for (int i = 1; i <= 10000; i++) {
            cur = Math.max(pre1, pre2 + i * count[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
