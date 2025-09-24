





// 给定一个非空的正整数数组和一个目标值 S，如果为每个数字添加“+”或“-”运算符，请计算有多少种方法可以使这些整数的计算结果为 S
// 例如，如果输入数组[2, 2, 2]并且 S 等于 2，有 3 种添加“+”或“-” 的方法使结果为 2，它们分别是 2+2-2=2、2-2+2=2 及-2+2+2=2




public class _15findWays {
    

    // 如果令所有使用 “+” 的数字的和为 P，所有使用 “-” 的数字的和为 Q，那么P - Q = S
    // 同时，P + Q = sum
    // 所以，2P = S + sum
    // 所以，P = (S + sum) / 2

    // 等价于计算从数组中选出和为(S+sum)/2 的数字的方法的数目。

    // j == 0时， f(i, j) = 1
    // i == 0 && j > 0时， f(i, j) = 0
    // i > 0 && j >= nums[i-1]时，f(i, j) = f(i-1, j) + f(i-1, j-nums[i-1])


    public int find(int[] nums, int S) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S > sum || (S + sum) % 2 == 1) {
            return 0;
        }

        return subsetSum(nums, (S + sum) / 2);
    }


    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
