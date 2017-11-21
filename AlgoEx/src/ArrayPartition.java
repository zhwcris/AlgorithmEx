public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        int[] hashTable = new int[20001];
        int result = 0;
        boolean flag = true;
        for(int i = 0; i < nums.length; i++){
            hashTable[nums[i]+10000]++;
        }
        for(int i = 0; i < hashTable.length;){
            if(hashTable[i] > 0){
                if(flag == true){
                    result += i - 10000;
                    hashTable[i]--;
                    flag = false;
                }else {
                    flag = true;
                    hashTable[i]--;
                }
            }else {
                i++;
            }
        }
        return result;
    }
}
