public class NonNegativeIntWithoutConsecutiveOne {
    public int findIntegers(int num) {//the number of length k string without consecutive 1 is Fibonacci sequence f(k);
        int[] f = new int[33];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        int k = 30, res = 0;
        boolean before = false;//标识前一位遇到1
        while (k >= 0){
            if((num & 1<<k) != 0){
                res += f[k];
                if(before)return res;
                before = true;
            }else {
                before = false;
            }
            k--;
        }
        return res + 1;
    }
}
