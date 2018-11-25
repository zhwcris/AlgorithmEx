import java.util.HashMap;
import java.util.HashSet;

public class CountTheRepetitions {

    //all come from these solutions
    /*
    https://leetcode.com/problems/count-the-repetitions/discuss/95398/C%2B%2B-solution-inspired-by-%4070664914-with-organized-explanation
    https://leetcode.com/problems/count-the-repetitions/discuss/95420/C%2B%2B-3ms-find-reoccurence-and-skip
    https://leetcode.com/problems/count-the-repetitions/discuss/119679/brutal-force-%2B-optimization-easy-understanding-c%2B%2B
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = 0, j = 0, count = 0;
        HashMap<Integer, int[]> map = new HashMap<>();//记录在当match到一个s2时，此时在s1中的位置，此时已经match到s2的数量
        while (i < len1 * n1){
            int locInS1 = i%len1;
            if(s1.charAt(locInS1) == s2.charAt(j)){
                j++;
                if(j == s2.length()){
                    j = 0;
                    count++;
                    if(!map.containsKey(locInS1)){
                        map.put(locInS1, new int[]{i,count});
                    }else {
                        int[] pre = map.get(locInS1);//上一个搜索到在s1同一位置时，在总长度中的位置和已经匹配到的s2

                        int recycle = (len1 * n1 - 1 - pre[0]) / (i - pre[0]);

                        i = pre[0] + recycle * (i - pre[0]);
                        count = pre[1] + recycle * (count - pre[1]);
                    }
                }
            }
            i++;
        }
        int res = count / n2;;
        return res;
    }


    public int getMaxRepetitions1(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        int j = 0, count = 0;
        for (int k = 0; k < n1; k++) {
            for (int i = 0; i < len1; i++) {
                if(s1.charAt(i) == s2.charAt(j)){
                    j++;
                    if(j == s2.length()){
                        j = 0;
                        count++;
                    }
                }
            }
        }
        int res = count / n2;;
        return res;
    }
}
