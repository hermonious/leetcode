

// 输入字符串 s1 和 s2，如何判断字符串 s2 中是否包含字符串 s1 的某个变位词(隐含条件是s1的长度 < s2的长度)
public class _1checkInclusion{

    public boolean checkinclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        // 用一个长度为 26 的数组 cnt 记录字符频次差（s1 中字符的频次减去 s2 中对应位置字符的频次）
        // 初始化 cnt 数组，记录 s1 中每个字符的频次
        int[] cnt = new int[26];
        for (int i = 0; i < len1; ++i) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        // 若某一时刻频次差全为 0，说明当前窗口是 s1 的排列，返回 true
        if (allZero(cnt)) {
            return true;
        }

        
        // 滑动窗口遍历剩余字符
        for (int i = len1; i < len2; ++i) {
            // 加入窗口右侧新字符（s2[i]）：频次差 -1
            cnt[s2.charAt(i) - 'a']--;
            // 移除窗口左侧旧字符（s2[i - len1]）：频次差 +1
            cnt[s2.charAt(i - len1) - 'a']++;
            // 检查当前窗口是否匹配
            if (allZero(cnt)) {
                return true;
            }
        }
        return false;
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