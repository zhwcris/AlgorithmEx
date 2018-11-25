public class UniqueSubInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        if(p == null || p.length() == 0)return 0;
        int res = 0, curCount = 0, preCount = 1, len = p.length();
        int[] count = new int[26];//the count of substring ends with p[i] ,保留最多的那一个
        count[p.charAt(0)-'a'] = 1;
        for (int i = 1; i < len; i++) {
            char c = p.charAt(i);
            char preC = p.charAt(i-1);
            if(c == preC + 1 || (c == 'a' && preC == 'z')){
                curCount = preCount + 1;
            }else {
                curCount = 1;
            }
            preCount = curCount;
            int index = c - 'a';
            count[index] = Math.max(curCount, count[index]);
        }
        for (int i = 0; i < 26; i++) {
            res += count[i];
        }
        return res;
    }
}
