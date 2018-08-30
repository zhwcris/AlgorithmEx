/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/4
 */
public class MaxDisToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int p = -1, p1 = 0, max;
        while (p1 < seats.length && seats[p1] == 0)p1++;
        max = p1;
        while (p1 < seats.length){
            if(seats[p1] == 1){
                max = Math.max(max, (p1 - p) / 2);
                p = p1;
            }
            p1++;
        }
        max = Math.max(max, p1 - 1 - p);
        return max;
    }

    public int maxDistToClosest1(int[] seats) {
        int p = -1, p1 = 0, max = 0;
        while (p1 < seats.length){
            if(seats[p1] == 1){
                if(p == -1){
                    max = Math.max(max, p1);
                }else {
                    max = Math.max(max, (p1 - p) / 2);
                }
                p = p1;
            }
            p1++;
        }
        max = Math.max(max, p1 - 1 - p);
        return max;
    }
}
