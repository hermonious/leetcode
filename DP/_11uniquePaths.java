
import java.util.Arrays;


// 一个机器人从 m×n 的格子的左上角出发，它每步要么向下要么向右，直到抵达格子的右下角。
// 请计算机器人从左上角到达右下角的路径的数目


public class _11uniquePaths {
    

    // 可以用函数 f(i, j) 表示从格子的左上角坐标为(0, 0)的位置出发到达坐标为(i, j)的位置的路径的数目
    // i = 0 时，f(0, j) = 1
    // j = 0 时，f(i, 0) = 1
    // 其他情况，f(i, j) = f(i-1, j) + f(i, j-1)


    public int path(int m, int n) {

        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);
    }


    private int helper(int i, int j, int[][] dp) {
        
        if (dp[i][j] == 0) {
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = helper(i - 1, j, dp) + helper(i, j - 1, dp);
            }
        }
        return dp[i][j];
    }




    // 迭代代码
    public int findPath(int m, int n) {

        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }





    // 优化空间效率
    public int findpAth(int m, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

}
