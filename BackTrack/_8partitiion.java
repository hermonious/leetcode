




// 输入一个字符串，要求将它分割成若干子字符串，使每个子字符串都是回文。请列出所有可能的分割方法。
// 例如，输入"google"，将输出3 种符合条件的分割方法，分别是["g", "o", "o", "g", "l", "e"]、["g", "oo", "g", "l", "e"]和["goog", "l", "e"]
import java.util.LinkedList;
import java.util.List;


public class _8partitiion {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new LinkedList<>();
        helper(s, 0, new LinkedList<>(), res);

        return res;
    }

    private void helper(String str, int start, LinkedList<String> substrings, List<List<String>> res) {

        if (start == str.length()) {
            res.add(new LinkedList<>(substrings));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                substrings.add(str.substring(start, i + 1));
                helper(str, i + 1, substrings, res);
                substrings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
