/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/6/27
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 && p2 >= 0){
            nums1[index--] = nums2[p2] > nums1[p1] ? nums2[p2--] : nums1[p1--];
        }

        while (p2 >= 0){
            nums1[index--] = nums2[p2--];
        }
    }
}
