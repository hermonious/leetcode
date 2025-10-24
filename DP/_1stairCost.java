

// 一个数组 cost 的所有数字都是正数，它的第 i 个数字表示在一个楼梯的第 i 级台阶往上爬的成本，在支付了成本 cost[i]之后可以从第 i 级台阶往上爬 1 级或 2 级。
// 假设台阶至少有 2 级，既可以从第 0 级台阶出发，也可以从第 1 级台阶出发，请计算爬上该楼梯的最少成本。
// 例如，输入数组[1, 100, 1, 1, 100, 1]，则爬上该楼梯的最少成本是 4-------分别经过下标为 0、2、3、5 的这 4 级台阶


// 状态转移方程表示为f(i) = min(f(i-1), f(i-2)) + cost[i]

public class _1stairCost {

    // 1.递归
    public int minClimb(int[] cost) {
        int len = cost.length;
        return Math.min(helper(cost, len - 2), helper(cost, len - 1));
    }

    private int helper(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        return Math.min(helper(cost, i - 2), helper(cost, i - 1)) + cost[i];
    }


    

    // 2.使用缓存的递归，避免重复计算
    public int minclimb(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        helper(cost, len - 1, dp);

        return Math.min(dp[len - 2], dp[len - 1]);
    }

    private void helper(int[] cost, int i, int[] dp) {
        if (i < 2) {
            dp[i] = cost[i];
        } else if (dp[i] == 0) {
            helper(cost, i - 2, dp);
            helper(cost, i - 1, dp);
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
    }




    // 3.空间复杂度O(n)的迭代
    public int mincLimb(int[] cost) {

        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[len - 2], dp[len - 1]);
    }



    // 4.空间复杂度O(1)的迭代,最佳方法
    // 在求每个 f(i)的时候，需要保存之前的 f(i-1)和 f(i-2)的结果，因此只要一个长度为 2 的数组即可
    public int minc1imb(int[] cost) {

        int[] dp = new int[]{cost[0], cost[1]};

        for (int i = 2; i < cost.length; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}
