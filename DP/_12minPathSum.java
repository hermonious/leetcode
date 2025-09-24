



// 在一个 m×n（m、n 均大于 0）的格子中，每个位置都有一个数字。
// 一个机器人每步只能向下或向右，请计算它从格子的左上角到达右下角的路径的数字之和的最小值

public class _12minPathSum {
    


    // 函数 f(i, j)表示从格子的左上角坐标为(0, 0)的位置（用 grid[0][0]表示）出发到达坐标为(i, j)的位置（用 grid[i][j]表示）的路径的数字之和的最小值
    // i = 0时，f(0, j) = grid[0][0] + grid[0][1] + ... + grid[0][j]
    // j = 0时，f(i, 0) = grid[0][0] + grid[1][0] + ... + grid[i][0]
    // 其他情况，f(i, j) = grid[i][j] + min(f(i-1, j), f(i, j-1))


    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];

            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }






    // 优化空间效率
    public int minPath(int[][] grid) {

        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];

        for (int j = 1; j < grid[0].length; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];

            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[grid[0].length - 1];
    }
}
