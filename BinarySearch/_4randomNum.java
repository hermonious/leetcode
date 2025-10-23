


// 输入一个正整数数组 w，数组中的每个数字 w[i]表示下标 i 的权重，请实现一个函数 pickIndex 根据权重比例随机选择一个下标。
// 例如，如果权重数组 w 为[1, 2, 3, 4]，那么函数 pickIndex 将有 10%的概率选择 0、20% 的概率选择 1、30%的概率选择 2、40%的概率选择 3。
import java.util.Random;

class Solution {
    private int[] sums;
    private int total;
    private final Random random;

    public Solution(int[] w) {
        sums = new int[w.length];
        total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
        this.random = new Random(); // 初始化一次
    }

    public int pickIndex() {
        int p = random.nextInt(total); // p ∈ [0, total)
        int left = 0;
        int right = sums.length; // 使用左闭右开区间 [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2; // ✅ 正确的 mid 计算
            if (sums[mid] > p) {
                right = mid; // 缩小右边界
            } else {
                left = mid + 1; // 缩小左边界
            }
        }
        return left; // 循环结束时 left 即为答案
    }
}
