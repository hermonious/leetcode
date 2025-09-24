



// 输入字符串 S 和 T，请计算字符串 S 中有多少个子序列等于字符串 T。
// 例如，在字符串"appplep"中，有 3 个子序列等于字符串"apple"



public class _10numOfSub {
    


    // 用 f(i, j)表示字符串 S 下标从 0 到 i 的子字符串（记为 S[0..i]）中 = 字符串 T 下标从 0 到 j 的子字符串（记为 T[0..j]）的子序列的数目
    // i < j时， f(i, j) = 0
    

    // 如果字符串 S 中下标为 i 的字符（记为 S[i]） = 字符串 T 中下标为 j 的字符（记为 T[j]）
    // 当 S[i] = T[j] 时，f(i, j) = f(i - 1, j - 1) + f(i - 1, j)
    // 当 S[i] != T[j] 时，f(i, j) = f(i - 1, j)

    // S,T都为空时，f(-1, -1) = 1
    // S为空时，f(-1, j) = 0
    // T为空时，f(i, -1) = 1


    public int distinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 1;

        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = 1;

            for (int j = 0; j < len2; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }

        return dp[len1][len2];
    }








    // 优化空间效率
    public int distincT(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[] dp = new int[len2 + 1];
        dp[0] = 1;

        for (int i = 0; i < len1; i++) {
            for (int j = Math.min(len2 - 1, i); j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[len2];
    }
}
