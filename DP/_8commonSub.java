



// 输入两个字符串，请求出它们的最长公共子序列的长度

// 状态转移方程
// 用函数 f(i, j)表示第 1 个字符串中下标从 0 到 i 的子字符串（记为 s1[0..i]） and 第 2 个字符串中下标从 0 到 j 的子字符串（记为 s2[0..j]）的最长公共子序列的长度

// 如果 s1[i] == s2[j]
// 那么 f(i, j) = f(i - 1, j - 1) + 1

// 如果 s1[i] != s2[j]
// 那么 f(i, j) = max(f(i - 1, j), f(i, j - 1))

// i或者j为0时，求f(0, j)或f(i, 0)需要用到f(-1, j)或f(i, -1)
// 任意空字符串和另一个字符串的公共子序列的长度都是 0
// 所f(-1, j)的值等于 0,同理，f(i, -1)的值也等于 0

public class _8commonSub {
    public int commonSub(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[len1][len2];
    }





    // 优化效率
    // 需要注意的是，f(i, j)的值依赖于表格中左上角 f(i-1, j-1)的值、正上方 f(i-1, j)的值和同一行左边 f(i, j-1)的值。
    // 由于计算f(i, j)的值时只需要使用上方一行的值和同一行左边的值，因此实际上只需要保存表格中的两行就可以
    public int commonsUb(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 < len2) {
            return commonsUb(s2, s1);
        }

        int[][] dp = new int[2][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[i % 2][j + 1], dp[(i + 1) % 2][j]);
                }
            }
        }

        return dp[len1 % 2][len2];
    }






    // 为了让一个一维数组保存表格中的两行信息，一维数组的每个位置需要保存原来表格中上下两格的信息，即 f(i, j)和 f(i-1, j)都保存在数组 dp 下标 j+1 的位置。
    // 在计算 f(i, j)之前，“dp[j+1]”中保存的是 f(i-1, j)的值；在完成 f(i, j)的计算之后，“dp[j+1]”被 f(i, j)的值替换。 
    public int commoNsub(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 < len2) {
            return commoNsub(s2, s1);
        }

        int[] dp = new int[len2 + 1];

        for (int i = 0; i < len1; i++) {
            int prev = dp[0];

            for (int j = 0; j < len2; j++) {
                int cur;
                
                if (s1.charAt(i) == s2.charAt(j)) {
                    cur = prev + 1;
                } else {
                    cur = Math.max(dp[j], dp[j + 1]);
                }
                prev = dp[j + 1];
                dp[j + 1] = cur;
            }
        }

        return dp[len2];
    }
}
