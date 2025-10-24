



 // 输入字符串 s 和 t，请计算字符串 s 中有多少个子序列等于字符串 t。
 // 例如，在字符串 "appplep" 中，有 3 个子序列等于字符串 "apple"。


 /* 动态规划定义：
 *   用 f(i, j) 表示字符串 s 的前 i 个字符（s[0..i-1]）中，
 *   等于字符串 t 的前 j 个字符（t[0..j-1]）的子序列的数目。
 *
 * 边界条件：
 *   - 当 t 为空（j = 0）时，f(i, 0) = 1（空字符串是任意字符串的子序列）
 *   - 当 s 为空而 t 非空（i = 0, j > 0）时，f(0, j) = 0
 *   - f(0, 0) = 1（两个空字符串匹配）
 *
 * 状态转移方程：
 *   - 若 s[i-1] == t[j-1]：
 *         f(i, j) = f(i-1, j-1) + f(i-1, j)
 *     （可以选择匹配当前字符，或跳过 s[i-1]）
 *   - 若 s[i-1] != t[j-1]：
 *         f(i, j) = f(i-1, j)
 *     （只能跳过 s[i-1]）
 *
 * 注意：虽然题目保证最终结果在 32 位有符号整数范围内，
 *       但中间计算过程可能溢出 int，因此使用 long 类型进行 DP。
 */
class Solution {
    public int numDistinct(String s, String t) {
        
        int len1 = s.length();
        int len2 = t.length();

        // dp[i][j] 表示 s[0..i-1] 中包含 t[0..j-1] 作为子序列的个数
        long[][] dp = new long[len1 + 1][len2 + 1];
        dp[0][0] = 1;

        // 初始化：t 为空时，所有 s[0..i-1] 都有 1 个匹配（空子序列）
        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = 1;
        }

        // 填充 DP 表
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return (int) dp[len1][len2];
    }

    /**
     * 空间优化版本：使用一维 DP 数组。
     * 由于 dp[i+1][j+1] 只依赖于上一行的 dp[i][j] 和 dp[i][j+1]，
     * 可以从后往前更新 j，避免覆盖尚未使用的值。
     */
    public int distinctOptimized(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        long[] dp = new long[len2 + 1];
        dp[0] = 1; // t 为空的情况

        for (int i = 0; i < len1; i++) {
            // 从后往前遍历 j，确保 dp[j] 是上一轮（i-1）的值
            for (int j = Math.min(len2 - 1, i); j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return (int) dp[len2];
    }
}
