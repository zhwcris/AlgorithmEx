public class PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] a = dominoes.toCharArray();
        int[] dis = new int[n];
        for (int i = 1; i < n; i++) {
            if(a[i-1] == 'R' && a[i] == '.'){
                a[i] = 'R';
                dis[i] = dis[i-1] + 1;
            }
        }

        for (int i = n-2, toL = 0; i >= 0; i--) {
            if(a[i+1] == 'L'){
                toL = dis[i+1] + 1;
                if(a[i] == '.' || dis[i] > toL){
                    a[i] = 'L';
                    dis[i] = toL;
                }else if(a[i] == 'R' && dis[i] == toL){
                    a[i] = '.';
                }
            }
        }
        return new String(a);
    }

    public String pushDominoes2(String dominoes) {//use L R 代表前I个字符的最后一个'L' 和 'R'
        char[] a = dominoes.toCharArray();
        int L = -1, R = -1;//positions of last seen L and R
        for (int i = 0; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)//R..R, turn all to R
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L')
                if (L > R || (R == -1 && L == -1))//L..L, turn all to L
                    while (++L < i)
                        a[L] = 'L';
                else { //R...L
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) { //one in the middle stays '.'
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
        return new String(a);
    }
}
