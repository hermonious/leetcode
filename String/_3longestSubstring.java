

// 输入一个字符串，求该字符串中不含重复字符的最长子字符串的长度

public class _3longestSubstring {
    // 1.多次遍历哈希表
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        // 因字符的 ASCII 码范围可覆盖 256 个值，记录每个字符的出现次数
        int[] cnt = new int[256];
        int i = 0;// 窗口右指针
        int j = -1;// 窗口左指针的前一位（初始窗口为 [0,0]，即 j+1=0），这样可以确保长度能正确计算
        int longest = 1;//最长无重复子串长度（至少为 1，因非空字符串）

        for(; i < s.length(); ++i) {
            // 右指针移动：将当前字符加入窗口，计数 +1
            cnt[s.charAt(i)]++;
            // 若窗口中存在重复字符（某字符计数 >1），收缩左边界
            while(hasGreaterThan1(cnt)) {
                ++j;//左边界右移
                cnt[s.charAt(j)]--;//移除左边界字符，计数 -1
            }
            // 窗口 [j+1, i] 的长度为 i - (j+1) + 1 = i - j
            longest = Math.max(i - j, longest);
        }
        return longest;
    }
    private boolean hasGreaterThan1(int[] cnt) {
        for(int count : cnt) {
            if(count > 1) {
                return true;
            }
        }
        return false;
    }






    // 优化，引入 cntDup 变量消除了原解法中遍历整个计数数组的开销
    // 定义一个变量cntDup来存储哈希表中大于1的数字的个数，即子字符串中重复字符的个数
    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int[] cnt = new int[256];
        int i = 0;
        int j = -1;
        int longest2 = 1;
        int cntDup = 0;// 记录当前窗口中重复字符的种类数（计数≥2的字符数）

        for(; i < s.length(); ++i) {
            cnt[s.charAt(i)]++;
            // 若当前字符计数从1变为2，说明新增了一种重复字符，cntDup+1
            // 只有当字符计数首次达到 2 时（从无重复变为重复），才增加 cntDup。若计数已≥2（如从 2→3），则不重复计数
            if(cnt[s.charAt(i)] == 2) {
                cntDup++;
            }

            // 如果存在重复字符，就收缩左边界
            while(cntDup > 0) {
                ++j;
                cnt[s.charAt(j)]--;
                // 若该字符计数从2变为1，说明减少了一种重复字符，cntDup-1
                if(cnt[s.charAt(j)] == 1) {
                    cntDup--;
                }
            }
            longest2 = Math.max(i - j, longest2);
        }
        return longest2;
    }
}
