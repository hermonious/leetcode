



// 输入一个没有重复数字的单调递增的数组，数组中至少有 3 个数字，请问数组中最长的斐波那契数列的长度是多少？
// 例如，如果输入的数组是[1, 2, 3, 4, 5, 6, 7, 8]，由于其中最长的斐波那契数列是 1、2、3、5、8，因此输出是 5



// 将数组记为 A，A[i]表示数组中下标为 i 的数字。
// 对于每个 j（0≤ j < i），A[j]都有可能是在某个斐波那契数列中 A[i]前面的一个数字。
// 如果存在一个 k（0≤ k < j）满足 A[k] + A[j] = A[i]，那么这 3 个数字就组成了一个斐波那契数列。
// 这个以 A[i]为结尾、前一个数字是 A[j]的斐波那契数列是在以 A[j]为结尾、前一个数字是 A[k]的序列的基础上增加一个数字 A[i]，因此前者的长度是在后者的长度的基础上加 1

// 状态转移方程有两个参数 i 和 j，f(i, j)表示以 A[i]为最后一个数字、A[j]为倒数第 2 个数字的斐波那契数列的长度。
// 如果数组中存在一个数字 k，使 A[i]= A[j]+A[k]（0≤k<j<i），那么 f(i, j)=f(j, k)+1

// 需要一个二维数组来缓存 f(i, j)的计算结果。i 对应二维数组的行号，j 对应二维数组的列号。
// 由于 i 大于j，因此实际上只用到了二维数组的左下角部分。如果数组的长度是 n，那么 i 的取值范围为 1～n-1，而 j 的取值范围为 0～n-2
import java.util.HashMap;
import java.util.Map;

public class _6longestFib {
    public int fib(int[] A) {
        // 输入数组是严格递增排序的，因此也可以用二分查找算法来确定是否存在符合条件的 A[k]
        // 如果采用二分查找，那么就不需要使用哈希表，但时间复杂度将会增加到 O(n^2logn)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        int[][] dp = new int[A.length][A.length];
        int res = 2;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int k = map.getOrDefault(A[i] - A[j], -1);
                
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}
