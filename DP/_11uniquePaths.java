



// 一个机器人从 m×n 的格子的左上角出发，它每步要么向下要么向右，直到抵达格子的右下角。
// 请计算机器人从左上角到达右下角的路径的数目


// 可以用函数 f(i, j) 表示从格子的左上角坐标为(0, 0)的位置出发到达坐标为(i, j)的位置的路径的数目
    // i = 0 时，f(0, j) = 1
    // j = 0 时，f(i, 0) = 1
    // 其他情况，f(i, j) = f(i-1, j) + f(i, j-1)

/*
 * 注意：由于题目保证 m, n ≥ 1，且所有可达位置的路径数 ≥ 1，
 *       因此可用 dp[i][j] == 0 作为“未计算”的判断条件。
 */
class Solution {
    public int uniquePaths(int m, int n) {
        // 创建记忆化数组，初始值为 0
        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);
    }

    private int helper(int i, int j, int[][] dp) {
        // 若尚未计算（本题中所有有效路径数 ≥ 1，0 表示未计算）
        if (dp[i][j] == 0) {
            // 边界：位于第一行或第一列时，只有一种走法
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                // 状态转移：从上方或左方转移而来
                dp[i][j] = helper(i - 1, j, dp) + helper(i, j - 1, dp);
            }
        }
        return dp[i][j];
    }
}






    
    // 迭代代码
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    
    // // 初始化第一行
    //     Arrays.fill(dp[0], 1);
    
    // // 初始化第一列
    //     for (int i = 1; i < m; i++) {
    //         dp[i][0] = 1;
    //     }
    
    // // 填充其余格子
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }



    
    // 优化空间效率代码
    // public int findPath(int m, int n) {

    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);

    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[j] += dp[j - 1];
    //         }
    //     }
    //     return dp[n - 1];
    // }
}
