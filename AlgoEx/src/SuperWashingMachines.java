/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/4
 */
public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + machines[i-1];
        }
        if(sum[n]%n != 0){
            return -1;
        }
        int avg = sum[n] / n;
        int res = 0, tmp;
        for (int i = 0; i < n; i++) {
            int left = avg * i - sum[i];
            int right = avg * (n - 1 - i) - (sum[n] - sum[i+1]);
            if(left > 0 && right > 0){
                res = Math.max(res, left + right);
            }else {
                tmp = Math.max(Math.abs(left), Math.abs(right));
                res = Math.max(tmp, res);
            }
        }
        return res;
    }

    public int findMinMoves1(int[] machines) {//top solution
        int total = 0;
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}
