

// 输入一个整数数组，如果一个数字左边的子数组的数字之和等于右边的子数组的数字之和，那么返回该数字的下标
public class _7indexOfPivot {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for(int num : nums) {
            total += num;
        }

        int sum = 0;
        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            // 左侧元素和 = 右侧元素和
            // total是元素总和，而sum是前缀和，nums[i]是中间的元素
            if(sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }
}
