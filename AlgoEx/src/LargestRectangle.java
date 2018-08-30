import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/4/26
 */
public class LargestRectangle {
    public int largestRectangleArea1(int[] heights) {
        int max = 0, n = heights.length, h, area, left;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])){
                h = heights[stack.pop()];
                left = stack.isEmpty() ? -1 : stack.peek();
                area = h * (i - left - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int n = heights.length, max = 0, p;
        int[] leftFirstLess = new int[n];
        int[] rightFirstLess = new int[n];

        leftFirstLess[0] = -1;
        rightFirstLess[n-1] = n;
        for(int i = 1; i < n; i++){
            p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = leftFirstLess[p];
            }
            leftFirstLess[i] = p;
        }
        for(int i = n - 2; i >= 0; i--){
            p = i + 1;
            while (p < n && heights[p] >= heights[i]){
                p = rightFirstLess[p];
            }
            rightFirstLess[i] = p;
        }
        for(int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (rightFirstLess[i] - leftFirstLess[i] -1));
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE, n = heights.length, h, areaRecord;
        for(int i = 0; i < n; i++){
            h = heights[i];
            max = Math.max(heights[i], max);
            for(int j = i + 1; j< n; j++){
                h = Math.min(h, heights[j]);
                areaRecord = (j - i + 1) * h;
                max = Math.max(max, areaRecord);
            }
        }
        return max;
    }
}
