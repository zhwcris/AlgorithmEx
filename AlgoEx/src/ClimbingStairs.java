/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/11/1
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int f1 = 1, f2 = 2, f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        if(n == 1)return f1;
        if(n == 2)return f2;
        return f3;
    }
}
