/**
 * Created with IntelliJ IDEA.
 * User: zhanghongwei
 * Date: 2018/12/17
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length(), l, r, max = 0, maxL = 0, maxR = 0;
        for (int i = 0; i < n; i++) {
            for (l = i - 1, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++);
            if(r - l - 1 > max){
                max = r - l - 1;
                maxL = l + 1;
                maxR = r;
            }
            for (l = i, r = i + 1; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++);
            if(r - l - 1 > max){
                max = r - l - 1;
                maxL = l + 1;
                maxR = r;
            }
        }
        if(maxL <= maxR)return s.substring(maxL, maxR);
        return "";
    }
}
