public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int ar = nums.length;
        int ac = nums[0].length;
        int nCount = ac * ar, index = 0;
        int i,j,k,l;
        if(nCount == r*c){
            int[][] array = new int[r][c];
            while (index < nCount){
                i = index/ac;
                j = index%ac;
                k = index/c;
                l = index%c;
                array[k][l] = nums[i][j];
                index++;
            }
            return array;
        }
        return nums;
    }
}
