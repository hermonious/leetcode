import java.util.ArrayList;
import java.util.List;

// 输入字符串 s1 和 s2，如何找出字符串 s2 的所有变位词在字符串 s1 中的起始下标（隐含条件是s1的长度 >= s2的长度）


// 思路和_1checkInclusion.java类似
public class _2findAll {
    public List<Integer> findall(String s1, String s2) {
        List<Integer> indices = new ArrayList<>();

        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2) {
            return indices;
        }

        int[] cnt = new int[26];
        int i = 0;
        for (; i < len2; ++i) {
            cnt[s2.charAt(i) - 'a']++;
            cnt[s1.charAt(i) - 'a']--;
        }
        if (allZero(cnt)) {
            indices.add(0);
        }

        for (; i < len1; ++i) {
            cnt[s1.charAt(i) - 'a']--;
            cnt[s1.charAt(i - len2) - 'a']++;
            if (allZero(cnt)) {
                indices.add(i - len2 + 1);
            }
        }
        return indices;
    }




    private boolean allZero(int[] cnt) {
        for(int count : cnt) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}
