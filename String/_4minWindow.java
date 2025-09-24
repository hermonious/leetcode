import java.util.HashMap;

// 输入两个字符串 s 和 t，请找出字符串 s 中包含字符串 t 的所有字符的最短子字符串



// 「最小覆盖子串」问题的经典解法，核心是通过 滑动窗口的扩展与收缩
// 配合 哈希表记录字符需求 和 cnt 变量追踪覆盖状态，高效找到最短子串
public class _4minWindow {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
    
    HashMap<Character,Integer> charCnt = new HashMap<>();
    for(char ch : t.toCharArray()) {
        charCnt.put(ch, charCnt.getOrDefault(ch, 0) + 1);
    }

    int cnt = charCnt.size();
    int start = 0;
    int end = 0;
    int minStart = 0;
    int minEnd = 0;
    int minLen = Integer.MAX_VALUE;

    while(end < s.length() || (cnt == 0 && end == s.length())) {
        if(cnt > 0) {
            char endCh = s.charAt(end);
            if(charCnt.containsKey(endCh)) {
                charCnt.put(endCh, charCnt.get(endCh) - 1);
                if(charCnt.get(endCh) == 0) {
                    cnt--;
                }
            }
            end++;
        } else {
            if(end - start < minLen) {
                minLen = end - start;
                minStart = start;
                minEnd = end;
            }
            char startCh = s.charAt(start);
            if(charCnt.containsKey(startCh)) {
                charCnt.put(startCh, charCnt.get(startCh) + 1);
                if(charCnt.get(startCh) == 1) {
                    cnt++;
                }
            }
            start++;
        }
    }
    return minLen < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : ""; 
    }
}
