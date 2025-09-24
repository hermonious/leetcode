




// 给定一个非空的正整数数组，请判断能否将这些数字分成和相等的两部分。
// 例如，如果输入数组为[3, 4, 1]，将这些数字分成[3, 1]和[4]两部分，它们的和相等，因此输出 true
// 如果输入数组为[1, 2, 3, 5]，则不能将这些数字分成和相等的两部分，因此输出 false




public class _14partitionEqual {
    

    // 函数 f(i, j)表示能否从前 i 个物品（物品标号分别为 0,1,…,i-1）中选择若干物品放满容量为 j 的背包
    // 判断能否从前 i 个物品中选择若干装满容量为 j 的书包时，需要考虑两种情况：
    // 1. 不选择第 i - 1 个物品，如果能从前 i-1 个物品中选择若干装满容量为 j 的书包，即：f(i - 1, j) = true，那么f(i, j) = true
    // 2. 选择第 i - 1 个物品，此时背包的容量为 j-weight[i - 1], 即：f(i - 1, j - weight[i - 1]) = true，那么f(i, j) = true

    // j = 0时， 只要不选就可以装满，所以f(i , 0) = true
    // i = 0时， 肯定装不满，所以f(0, j) = false


    public boolean partition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return subsetSum(nums, sum / 2);
    }

    private boolean subsetSum(int[] nums, int target) {
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return helper(nums, dp, nums.length, target);
    }

    private boolean helper(int[] nums, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][j] = true;
            } else if (i == 0) {
                dp[i][j] = false;
            } else {
                dp[i][j] = helper(nums, dp, i - 1, j);

                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = helper(nums, dp, i - 1, j - nums[i - 1]);
                }
            }
        }
        return dp[i][j];
    }








    // 迭代代码
    private boolean partition1(int[] nums, int target) {

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }







    // 优化空间效率
    private boolean partitioN(int[] nums, int target) {

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j > 0; j--) {
                
                if (!dp[j] && j >= nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]];
                }
            }
        }

        return dp[target];
    }
}
