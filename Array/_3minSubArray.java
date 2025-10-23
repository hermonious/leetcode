
// 输入一个正整数组成的数组和一个正整数 k，求数组中和大于或等于 k 的连续子数组的最短长度


// 滑动窗口
public class _3minSubArray {
    public int minSubArrayLen(int k, int[] nums) {
        int i = 0;//左指针
        int sum = 0;//窗口内的元素和

        // 要求最小长度，所以初始化为最大值，方便后续使用min()函数
        int minL = Integer.MAX_VALUE;

        // for循环，右指针扩大窗口
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];

            // while循环，左指针缩小窗口
            while(i <= j && sum >= k) {
                minL = Math.min(minL, j - i + 1);
                // 移除左指针元素，缩小窗口
                sum -= nums[i];
                i++;
            }
        }
        // 如果minLength没有被更新，说明没有符合条件的子数组，返回0
        // 否则，返回minLength
        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}
