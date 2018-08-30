import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/26
 */
public class NumSubBoundedMax {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j=0,count=0,res=0;

        for(int i=0;i<A.length;i++){
            if(A[i]>=L && A[i]<=R){
                res+=i-j+1;count=i-j+1;
            }
            else if(A[i]<L){
                res+=count;
            }
            else{
                j=i+1;
                count=0;
            }
        }
        return res;
    }

    public int numSubarrayBoundedMax3(int[] A, int L, int R) {
        int res = 0, left = -1, right = -1;
        for (int i = 0; i < A.length; i++){
            if(A[i] > R)left = i;
            if(A[i] >= L) right = i;
            res += right - left;
        }
        return res;
    }

    public int numSubarrayBoundedMax1(int[] A, int L, int R) {
        int res = 0, index, last = 0, next;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] >= L)list.add(i);
        }
        int n = list.size(), i;
        for (i = 0; i < n - 1; i++) {
            index = list.get(i);
            if(A[index] > R){
                last = index + 1;
                continue;
            }
            next = list.get(i+1) - 1;
            res += getSubNum(last, index, next);
        }
        index = list.get(i);
        if(A[index] <= R){
            next = A.length - 1;
            res += getSubNum(last, index, next);
        }

        return res;
    }

    public int numSubarrayBoundedMax2(int[] A, int L, int R) {
        int res = 0, index, last = 0, next;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] >= L)list.add(i);
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            index = list.get(i);
            if(A[index] > R){
                last = index + 1;
                continue;
            }
            if(i + 1 < n){
                next = list.get(i+1) - 1;
            }else {
                next = A.length - 1;
            }
            res += getSubNum(last, index, next);
        }
        return res;
    }

    private int getSubNum(int l, int mid, int r){
        return r - l + 1 + (mid - l) * (r - mid);
    }
}
