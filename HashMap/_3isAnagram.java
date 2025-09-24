import java.util.HashMap;
import java.util.Map;

// 给定两个字符串 s 和 t，请判断它们是不是一组变位词。
// 在一组变位词中，它们中的字符及每个字符出现的次数都相同，但字符的顺序不能相同


public class _3isAnagram {
    

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] cnt = new int[26];
        for (char ch : s1.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            if (cnt[ch - 'a'] == 0) {
                return false;
            }
            cnt[ch - 'a']--;
        }
        return true;
    }



    // 如果考虑非英文字母，则用真正的哈希表 HashMap 
    public boolean _3isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            if (!cnt.containsKey(ch) || cnt.get(ch) == 0) {
                return false;
            }
            cnt.put(ch, cnt.get(ch) - 1);
        }
        return true;
    }
}
