



// 一条环形街道上有若干房屋。输入一个数组表示该条街道上的房屋内财产的数量。
// 如果这条街道上相邻的两幢房屋被盗就会自动触发报警系统。请计算小偷在这条街道上最多能偷取的财产的数量。
// 例如，街道上 5 家的财产用数组[2, 3, 4, 5, 3]表示，如果小偷到下标为 1 和 3 的房屋内盗窃，那么他能偷取到价值为 8 的财物，这是他在不触发报警系统的情况下能偷取到的最多的财物


// 将这个问题分解成两个子问题：一个问题是求小偷从标号为 0 开始到标号为 n-2 结束的房屋内能偷得的最多财物数量，
// 另一个问题是求小偷从标号为 1 开始到标号为 n-1 结束的房屋内能偷得的最多财物数量。
// 小偷从标号为 0 开始到标号为 n-1 结束的房屋内能偷得的最多财物数量是这两个子问题的解的最大值
public class _3circleRob {
    public int rob(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int res1 = helper(nums, 0, nums.length - 2);
        int res2 = helper(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[2];
        dp[0] = nums[start];

        if (start < end) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }

        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j % 2] = Math.max(dp[(j - 2) % 2] + nums[i], dp[(j - 1)% 2]);
        }
        return dp[(end - start) % 2];
    }
}
