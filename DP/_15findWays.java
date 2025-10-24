





// 给定一个非空的正整数数组和一个目标值 S，如果为每个数字添加“+”或“-”运算符，请计算有多少种方法可以使这些整数的计算结果为 S
// 例如，如果输入数组[2, 2, 2]并且 S 等于 2，有 3 种添加“+”或“-” 的方法使结果为 2，它们分别是 2+2-2=2、2-2+2=2 及-2+2+2=2


// 如果令所有使用 “+” 的数字的和为 P，所有使用 “-” 的数字的和为 Q，那么P - Q = S
// 同时，P + Q = sum
// 所以，2P = S + sum
// 所以，P = (S + sum) / 2
// 等价于计算从数组中选出和为(S+sum)/2 的数字的方法的数目。

// j == 0时， f(i, j) = 1
// i == 0 && j > 0时， f(i, j) = 0
// i > 0 && j >= nums[i-1]时，f(i, j) = f(i-1, j) + f(i-1, j-nums[i-1])

class Solution {
    public int findTargetSumWays(int[] nums, int targetSum) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // 关键修正：使用绝对值判断，并检查奇偶性
        if (Math.abs(targetSum) > sum || (sum + targetSum) % 2 != 0) {
            return 0;
        }
        
        int target = (sum + targetSum) / 2;
        // target 必然 >= 0，因为 |targetSum| <= sum 且 (sum+targetSum) 为偶数
        
        return subsetSum(nums, target);
    }
    
    private int subsetSum(int[] nums, int target) {
        // dp[j] 表示组成和为 j 的方案数
        int[] dp = new int[target + 1];
        dp[0] = 1; // 和为 0 的方案数为 1（空集）
        
        for (int num : nums) {
            // 从后往前遍历，避免重复使用当前 num
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
