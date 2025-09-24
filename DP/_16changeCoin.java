




// 给定正整数数组 coins 表示硬币的面额和一个目标总额 t，请计算凑出总额 t 至少需要的硬币数目。
// 每种硬币可以使用任意多枚。如果不能用输入的硬币凑出给定的总额，则返回-1。
// 例如，如果硬币的面额为[1, 3, 9, 10]，总额 t 为 15，那么至少需要 3 枚硬币，即 2 枚面额为 3 的硬币及 1 枚面额为 9 的硬币




import java.util.Arrays;

public class _16changeCoin {
    



    // f(i, j) = min(f(i-1, j - K * coins[i-1]) + K)

    // 其中，0 <= K <= j / coins[i-1]
    // 边界条件：f(0, j) = 0, j >= 0
    // f(i, 0) = 0, i >= 0
    // 目标：f(n, t)


    public int coin(int[] coins, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;


        for (int coin : coins) {
            for (int j = target; j >= 1; j--) {
                for (int k = 1; k * coin <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                }
            }
        }

        return dp[target] > target ? -1 : dp[target];
    }






    // 另外一种思路：在总额为 i-coins[n-1]的硬币中添加 1 枚标号为 n-1 的硬币，此时 f(i)等于 f(i-coins[n-1])+1。因为目标是计算凑出总额为 i 的硬币，所以 f(i) 是上述所有情况的最小值
    // f(i) = min(f(i-coins[j])+1)
    // coins[j] <= i
    // 边界条件：f(0) = 0

    public int coin2(int[] coins, int target) {

        int[] dp = new int[target + 1];
        

        for (int i = 1; i <= target; i++) {
            dp[i] = target + 1;
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[target] > target ? -1 : dp[target];
    }
}




