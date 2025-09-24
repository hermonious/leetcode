

// 给定一个字符串，请问该字符串中有多少个回文连续子字符串
public class _7countSubstring {
    
    public int countSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                cnt += countPalindrome(s, i, i);
                cnt += countPalindrome(s, i, i + 1);
            }
        }
        return cnt;
    }


    private int countPalindrome(String s, int i, int j) {
        int cnt = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            cnt++;
            i--;
            j++;
        }
        return cnt;
    }
}



