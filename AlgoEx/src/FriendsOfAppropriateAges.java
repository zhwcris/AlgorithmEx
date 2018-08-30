/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/27
 */
public class FriendsOfAppropriateAges {

    /*  sliding window sum
    int numFriendRequests(vector<int>& ages) {
        int a[121] = {}, res = 0;
        for (auto age : ages) ++a[age];
        for (auto i = 15, minAge = 15, sSum = 0; i <= 120; sSum += a[i], res += a[i++] * (sSum - 1))
            while (minAge <= 0.5 * i + 7) sSum -= a[minAge++];
        return res;
}
     */


    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];

        for(int i : ages)
            numInAge[i] ++;

        for(int i = 1; i <= 120; ++i)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];

        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }

    public int numFriendRequests1(int[] ages) {
        int res = 0, j;
        int[] numInAge = new int[121];
        for (int i = 0; i < ages.length; i++) {
            numInAge[ages[i]]++;
        }
        for (int i = 15; i < numInAge.length; i++) {
            if(numInAge[i] == 0)continue;
            j = i;
            while (j >= 0){
                if(numInAge[j] == 0){
                    j--;
                    continue;
                }
                if(!isFriend(i, j))break;
                res += numInAge[i] * (numInAge[j] - (i == j ? 1 : 0));
                j--;
            }
        }
        return res;
    }

    private boolean isFriend(int A, int B){
        return 0.5 * A + 7 < B && B <= A;
    }
}
