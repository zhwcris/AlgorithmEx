public class StrangePrinter {// similar with remove boxes
    /**
     * f[i][j] represents the number we need to print the substring [i,j]
     * Boundary condition:
     * f[i][i]=1
     * f[i][i-1]=0
     *
     * For every i<j
     * f[i][j]=min{
     * 1+f[i+1][j],
     * f[i+1][k-1]+f[k][j] (when i<k<=j, s.charAt(i)==s.charAt(k))
     * }
     */

    public int strangePrinter(String s) {
        int n=s.length();
        int[][] f=new int[n][n];
        for (int i=n-1;i>=0;i--)
            for (int j=i;j<n;j++)
            {
                f[i][j]=(i==j)?1:1+f[i+1][j];
                for (int k=i+1;k<=j;k++)
                    if (s.charAt(k)==s.charAt(i)) f[i][j]=Math.min(f[i][j],f[i+1][k-1]+f[k][j]);
            }
        return (n==0?0:f[0][n-1]);
    }
}
