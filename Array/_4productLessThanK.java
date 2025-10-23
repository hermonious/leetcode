

// 输入一个由正整数组成的数组和一个正整数 k，请问数组中有多少个数字乘积小于 k 的连续子数组


// 滑动窗口
public class _4productLessThanK { 
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k <= 1) {
            return 0;
        }
        
        long product = 1;// 乘积
        int i = 0;       // 左指针
        int cnt = 0;     // 计数器

        // 外层for循环，右指针扩大窗口
        for(int j = 0; j < nums.length; j++) {
            product *= nums[j];

            // 内层while循环，左指针缩小窗口
            while(i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            // 如果right >= left，那么cnt += right - left + 1；否则，cnt += 0
            cnt += (right >= left ? right - left + 1 : 0);
        }
        return cnt;
    }
}
