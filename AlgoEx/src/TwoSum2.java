public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int sum = 0;
        for(int i = 0, j = numbers.length-1; i < j;){
            sum = numbers[i]+numbers[j];
            if(sum < target)i++;
            else if(sum > target)j--;
            else {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
