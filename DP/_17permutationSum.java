
// 给定一个非空的正整数数组 nums 和一个目标值 t，数组中的所有数字都是唯一的，请计算数字之和等于 t 的所有排列的数目。数组中的数字可以在排列中出现任意次
// 例如，输入数组[1, 2, 3]，目标值 t 为 3，那么总共有 4 个组合的数字之和等于 3，它们分别为{1, 1, 1}、{1, 2}、{2, 1}及{3}


// f(i) = f(i-nums[1]) + f(i-nums[2]) + ... + f(i-nums[j])
// nums[j] <= i
// 边界条件：f(0) = 1
public class _17permutationSum {
    public int sum(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
