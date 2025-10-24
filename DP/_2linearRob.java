

// 输入一个数组表示某条街道上的一排房屋内财产的数量。如果这条街道上相邻的两幢房屋被盗就会自动触发报警系统。请计算小偷在这条街道上最多能偷取到多少财产。
// 例如，街道上 5 幢房屋内的财产用数组[2, 3, 4, 5, 3]表示，如果小偷到下标为 0、2 和 4 的房屋内盗窃，那么他能偷取到价值为 9 的财物，这是他在不触发报警系统的情况下能偷取到的最多的财物

import java.util.Arrays;

public class _2linearRob {
    // f(i) = max(f(i-2) + nums[i], f(i-1))
    // 带缓存的递归
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        helper(nums, nums.length - 1, dp);
        return dp[nums.length - 1];
    }

    private void helper(int[] nums, int i, int[] dp) {
        
        if (i == 0) {
            dp[i] = nums[0];
        } else if (i == 1) {
            dp[i] = Math.max(nums[0], nums[1]);
        } else if (dp[i] < 0) {
            helper(nums, i - 2, dp);
            helper(nums, i - 1, dp);
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
    }




    
    // 空间复杂度O(n)的迭代
    public int roB(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }




    // 空间复杂度O(1)的迭代
    public int rOb(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 计算“dp[i]”时只需要用到“dp[i-1]” 和“dp[i-2]”这两个值
        int[] dp = new int[2];
        dp[0] = nums[0];
        
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 2) % 2] + nums[i], dp[(i - 1) % 2]);
        }

        return dp[(nums.length - 1) % 2];
    }




    // 使用 2 个状态转移方程
    // f(i)表示小偷选择不进入标号为 i 的房屋偷东西时能偷得的最多财物数量, f(i) = max(f(i-1), g(i-1))
    // g(i)表示小偷选择进入标号为 i 的房屋偷东西时能偷得的最多财物数量, g(i) = f(i-1) + nums[i - 1]
    // 这两个状态转移方程有一个隐含条件，要求 i 大于 0，否则 i-1 没有意义。
    // 当 i 等于 0 时，f(0)表示街道上只有标号为 0 的房屋并且小偷选择不进去偷东西，那么他什么也没有偷到，因此 f(0)=0。
    // g(0)表示当只有标号为 0 的房屋并且小偷选择进去偷东西，那么房屋内财物的价值就是小偷能偷取的东西的价值，即 g(0)=nums[0]

    public int Rob(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[1][0] = nums[0];

        // 二维数组 dp 用来模拟表
        // “dp[0][i%2]”中用来存放 f(i)的计算结果
        // “dp[1][i%2]”中用来存放 g(i)的计算结果
        for (int i = 1; i < len; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = dp[0][(i - 1) % 2] + nums[i];
        }

        return Math.max(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }
}
