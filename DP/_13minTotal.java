


/**
 * 给定一个三角形 triangle，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的节点上。
 * 相邻的节点在这里指的是下标与上一层节点下标相同或者加一的两个节点。
 * 
 * 动态规划解法（自顶向下）：
 * - 状态定义：dp[i][j] 表示从顶部到达第 i 行第 j 列位置的最小路径和
 * - 状态转移：
 *     • 若 j == 0（行首）：只能从上一行同列转移 → dp[i][j] = dp[i-1][j] + triangle[i][j]
 *     • 若 j == i（行尾）：只能从上一行前一列转移 → dp[i][j] = dp[i-1][j-1] + triangle[i][j]
 *     • 否则：dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
 * - 初始状态：dp[0][0] = triangle[0][0]
 * - 结果：最后一行中的最小值
 */
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        // 创建 DP 表，dp[i][j] 仅在 j <= i 时有效
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int currentValue = triangle.get(i).get(j);
                
                if (i == 0) {
                    // 起点
                    dp[i][j] = currentValue;
                } else if (j == 0) {
                    // 行首：只能从上方来
                    dp[i][j] = dp[i - 1][j] + currentValue;
                } else if (j == i) {
                    // 行尾：只能从左上方来
                    dp[i][j] = dp[i - 1][j - 1] + currentValue;
                } else {
                    // 中间位置：取上方和左上方的较小值
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + currentValue;
                }
            }
        }
        
        // 在最后一行中找最小路径和
        int minPathSum = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }
        
        return minPathSum;
    }
}



    //优化空间效率
    // public int minTotal2(List<List<Integer>> t) {

    //     int size = t.size();
    //     int[] dp = new int[size];

    //     for (List<Integer> row : t) {
    //         for (int j = row.size() - 1; j >= 0; j--) {

    //             if (j == 0) {
    //                 dp[j] += row.get(j);
    //             } else if (j == row.size() - 1) {
    //                 dp[j] = dp[j - 1] + row.get(j);
    //             } else {
    //                 dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
    //             }
    //         }
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for (int num : dp) {
    //         min = Math.min(min, num);
    //     }
    //     return min;
    // }

