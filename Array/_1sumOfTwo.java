


// 输入一个递增排序的数组和一个值 k，请问如何在数组中找出两个和为 k 的数字并返回它们的下标
// 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。



public class _1sumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        // 针对有序数组，使用双指针
        // 左指针指向数组头，右指针指向数组尾
        // 因为是递增数组，所以和小于目标值，左指针向右移动
        // 和大于目标值，右指针向左移动，直到找到目标值

        int i = 0;
        int j = nums.length - 1;

        while (i < j && nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        // 返回符合条件的下标
        return new int[] { i, j };
    }
}
