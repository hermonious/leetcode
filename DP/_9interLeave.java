


// 输入 3 个字符串 s1、s2 和 s3，请判断字符串 s3 能不能由字符串s1 和 s2 交织而成，即字符串 s3 的所有字符都是字符串 s1 或 s2 中的字符，字符串 s1 和 s2 中的字符都将出现在字符串 s3 中且相对位置不变。
// 例如，字符串"aadbbcbcac"可以由字符串"aabcc"和"dbbca"交织而成




public class _9interLeave {
    

    // 当 s3[i+j+1]和 s1[i]相同时，f(i, j)的值等于 f(i-1, j) 的值。
    // 当 s3[i+j+1]和 s2[j]相同时，f(i, j)的值等于 f(i, j-1)的值。
    // 如果 s1[i]和 s2[j]都和 s3[i+j+1]相同，此时只要 f(i-1, j)和 f(i, j-1)有一个值为true，那么 f(i, j)的值为 true



    // f(i, j)的值依赖于 f(i-1, j)和 f(i, j-1)的值
    // 如果 i 等于 0，那么 f(0, j)的值依赖于 f(-1, j)和 f(0, j-1)的值

    // f(-1, j)的值其实取决于子字符串 s2[0..j]和 s3[0..j]是否相同。
    // 如果 s2[j]和 s3[j] 不同，那么 f(-1, j)的值为 false；如果 s2[j]和 s3[j]相同，那么 f(-1, j)的值等于 f(-1, j-1)的值

    // f(i, -1)的值取决于子字符串 s1[0..i]和s3[0..i]是否相同。
    // 如果 s1[i]和 s3[i]不同，那么 f(i, -1)的值为 false；如果 s1[i] 和 s3[i]相同，那么 f(i, -1)的值等于 f(i-1, -1)的值

    //  i 和 j 都等于-1 时，f(-1, -1)的值的含义是两个空字符串能否交织得到一个空字符串。这显然是可以的，因此 f(-1, -1)的值为 true



    public boolean interLeave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }


        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i < len1; i++) {
            dp[i + 1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
        }

        for (int j = 0; j < len2; j++) {
            dp[0][j + 1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                
                dp[i + 1][j + 1] = (dp[i][j + 1] && ch1 == ch3) || (dp[i + 1][j] && ch2 == ch3);
            }
        }

        return dp[len1][len2];
    }







    // 优化空间效率
    public boolean isInterLeave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        if (len1 < len2) {
            return isInterLeave(s2, s1, s3);
        }

        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;

        for (int j = 0; j < len2; j++) {
            dp[j + 1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }

        for (int i = 0; i < len1; i++) {
            dp[0] = dp[0] && s1.charAt(i) == s3.charAt(i);

            for (int j = 0; j < len2; j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                
                dp[j + 1] = (dp[j + 1] && ch1 == ch3) || (dp[j] && ch2 == ch3);
            }
        }

        return dp[len2];
    }
}
