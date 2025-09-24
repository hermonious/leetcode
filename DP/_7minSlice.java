




// 输入一个字符串，请问至少需要分割几次才可以使分割出的每个子字符串都是回文？
// 例如，输入字符串"aaba"，至少需要分割 1 次，从两个相邻字符'a'中间切一刀将字符串分割成两个回文子字符串"a"和"aba"



public class _7minSlice {
    


    public int slice(String s) {

        int len = s.length();
        boolean[][] isPal = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2 && (i - j <= 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }

        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;

                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[len - 1];
    }
}
