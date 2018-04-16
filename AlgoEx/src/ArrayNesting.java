/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/1/20
 */
public class ArrayNesting {
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        int index;
        int num;
        int tmp;
        for(int i = 0; i < a.length; i++){
            index = i;
            num = 0;
            while(a[index] != -1){
                tmp = index;
                index = a[tmp];
                a[tmp] = -1;
                num++;
            }
            maxsize = maxsize < num ? num : maxsize;
        }
        return maxsize;
    }
}
