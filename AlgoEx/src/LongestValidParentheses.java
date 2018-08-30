import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/8/29
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s.length() <= 1)return 0;
        int n = s.length(), max = 0, cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    if(s.charAt(stack.peek()) == '('){
                        stack.pop();
                    }else {
                        stack.push(i);
                    }
                }
            }
        }
        if(stack.isEmpty())return n;
        int a = n, b = 0;
        while (!stack.isEmpty()){
            b = stack.pop();
            max = Math.max(max, a - b -1);
            a = b;
        }
        max = Math.max(max, a);
        return max;
    }

    public int longestValidParentheses1(String s) {
        if(s.length() <= 1)return 0;
        int res = 0, n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    res = Math.max(res, dp[i]);
                }else {
                    if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                        dp[i] = dp[i-1] + 2 + (i - dp[i-1] - 2 >= 0 ? dp[i - dp[i-1] - 2] : 0);
                        res = Math.max(res, dp[i]);
                    }
                }
            }
        }
        return res;
    }
}
