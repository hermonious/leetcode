

// 输入一个由正整数组成的数组和一个正整数 k，请问数组中有多少个数字乘积小于 k 的连续子数组
public class _4productLessThanK {
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k <= 1) {
            return 0;
        }
        long product = 1;
        int left = 0;
        int cnt = 0;


        // 和minSubArray.java类似，依旧采用滑动窗口
        // 外层for循环，右指针扩大窗口
        for(int right = 0; right < nums.length; ++right) {
            product *= nums[right];

            // 内层while循环，左指针缩小窗口
            while(left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            // 如果right >= left，那么cnt += right - left + 1；否则，cnt += 0
            cnt += right >= left ? right - left + 1 : 0;
        }
        return cnt;
    }
}
