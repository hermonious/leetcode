



// 一排 n 幢房子要粉刷成红色、绿色和蓝色，不同房子被粉刷成不同颜色的成本不同。
// 用一个 n×3 的数组表示 n 幢房子分别用 3 种颜色粉刷的成本。
// 要求任意相邻的两幢房子的颜色都不一样，请计算粉刷这 n 幢房子的最少成本。
// 例如，粉刷 3 幢房子的成本分别为[[17, 2, 16], [15, 14, 5], [13, 3, 1]]，如果分别将这 3 幢房子粉刷成绿色、蓝色和绿色，那么粉刷的成本是 10，是最少的成本



// r(i)、g(i)、b(i)，分别表示将标号为 i 的房子粉刷成红色、绿色和蓝色时粉刷标号从 0 到 i 的 i+1 幢房子的最少成本
// 状态转移方程：
// r(i) = min(g(i-1), b(i-1)) + cost[i][0]
// g(i) = min(r(i-1), b(i-1)) + cost[i][1]
// b(i) = min(r(i-1), g(i-1)) + cost[i][2]

// 有一个隐含条件，要求 i 大于 0，否则 i-1 没有意义
// 当 i 等于 0 时，r(0)就是将标号为 0 的房子粉刷成红色的成本 costs[0][0]
// g(0)就是将标号为 0 的房子粉刷成绿色的成本 costs[0][1]
// b(0)就是将标号为 0 的房子粉刷成蓝色的成本 costs[0][2]

public class _4painting {
    public int minCost(int[][] costs) {
        
        if (costs.length == 0) {
            return 0;
        }

        // 该二维数组一共有 3 行，分别对应 r(i)、g(i)和 b(i)
        // 由于计算 r(i)、g(i)和 b(i)时只需要用到 r(i-1)、g(i-1) 和 b(i-1)，因此并不需要用完整的一维数组来保存 r(i)、g(i)和 b(i)的值。
        // 于是，进一步优化空间效率，将数组 dp 的每行的长度精简为 2，r(i)、g(i)和 b(i) 分别保存在 3 行下标为“i % 2”的位置
        int[][] dp = new int[3][2];
        
        for (int j = 0; j < 3; j++) {
            dp[j][0] = costs[0][j];
        }

        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {

                int prev1 = dp[(j + 1) % 2][(i - 1) % 2];
                int prev2 = dp[(j + 2) % 2][(i - 1) % 2];

                dp[j][i % 2] = Math.min(prev1, prev2) + costs[i][j];
            }
        }

        int last = (costs.length - 1) % 2;
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }
}
