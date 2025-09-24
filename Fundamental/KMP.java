// 在主串 text 中查找模式串 pattern 是否存在，返回第一个匹配位置的索引（如不存在返回 -1）


public class KMP {

    /**
     * KMP 算法主函数：在 text 中查找 pattern 第一次出现的位置
     * @param text 主串
     * @param pattern 模式串
     * @return 第一次匹配的起始索引，未找到返回 -1
     */
    public static int kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) return 0;
        if (text.isEmpty()) return -1;

        // 步骤1：构建 next 数组（LPS：Longest Prefix Suffix）
        int[] next = buildNext(pattern);

        int n = text.length();
        int m = pattern.length();
        int i = 0; // text 的指针
        int j = 0; // pattern 的指针

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                // 如果 pattern 全部匹配完，找到结果
                if (j == m) {
                    return i - j; // 返回起始位置
                }
            } else {
                // 失配：根据 next 数组移动 j
                if (j != 0) {
                    j = next[j - 1]; // 回退 j
                } else {
                    i++; // j 已经是 0，只能移动 i
                }
            }
        }
        return -1; // 未找到匹配
    }






    /**
     * 构建 next 数组（LPS 数组）
     * next[i] 表示 pattern[0..i] 的最长相等真前后缀的长度
     * @param pattern 模式串
     * @return next 数组
     */
    public static int[] buildNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int len = 0; // 当前最长前后缀长度
        int i = 1;

        // next[0] 永远是 0（单个字符无真前后缀）
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // 回退到更短的前缀
                    len = next[len - 1];
                } else {
                    next[i] = 0;
                    i++;
                }
            }
        }
        return next;
    }
}