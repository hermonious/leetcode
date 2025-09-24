

// 给定一个字符串，请判断它是不是回文。假设只需要考虑字母和数字字符，并忽略大小写
public class _5isPalindrome {
    
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;


        while(i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!Character.isLetterOrDigit(ch1)) {
                i++;
            }else if(!Character.isLetterOrDigit(ch2)) {
                j--;
            }else {
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
