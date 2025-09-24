import java.util.List;



// 在一个由数字组成的三角形中，第 1 行有 1 个数字，第 2 行有 2 个数字，以此类推，第 n 行有 n 个数字。
// 例如，图 14.9 是一个包含 4 行数字的三角形。如果每步只能前往下一行中相邻的数字，请计算从三角形顶部到底部的路径经过的数字之和的最小值



public class _13minTotal {
    


    // 可以移动三角形每行的位置使它们左端对齐，如图 14.10 所示。对齐之后就能很方便地用矩阵的行坐标和列坐标来定位每个数字。
    // 如果三角形有 n 行数字，将这些行左端对齐之后就成了一个 n×n 的矩阵的左下半部分。
    // 如果三角形中某个数字在矩阵中的行号和列号分别是 i 和 j，那么 i≥j

    // 用 f(i, j)表示从三角形的顶部出发到达行号和列号分别为 i 和 j（i≥j）的位置时路径数字之和的最小值
    // 用 T[i][j]表示三角形行号和列号分别为 i 和 j 的数字


    // j = 0时，f(i, 0) = f(i - 1, 0) + T[i][0]
    // j = i时，f(i, i) = f(i - 1, i - 1) + T[i][i]
    // 其他情况，f(i, j) = min(f(i - 1, j - 1), f(i - 1, j)) + T[i][j]


    public int minTotal(List<List<Integer>> t) {

        int size = t.size();
        int[][] dp = new int[size][size];
        

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = t.get(i).get(j);

                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i > 0 && j == i) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            min = Math.min(min, num);
        }

        return min;
    }





    //优化空间效率
    public int minTotal2(List<List<Integer>> t) {

        int size = t.size();
        int[] dp = new int[size];

        for (List<Integer> row : t) {
            for (int j = row.size() - 1; j >= 0; j--) {

                if (j == 0) {
                    dp[j] += row.get(j);
                } else if (j == row.size() - 1) {
                    dp[j] = dp[j - 1] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + row.get(j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }

        return min;
    }
}
