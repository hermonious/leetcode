

// 给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串
public class _6validPalindrome {
    
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        for(; i < s.length() / 2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return i == s.length() / 2 || isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
    }


    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        return i >= j;
    }
}
