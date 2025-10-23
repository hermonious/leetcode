


// 输入一个排序的整数数组 nums 和一个目标值 t
// 如果数组 nums 中包含 t，则返回 t 在数组中的下标；如果数组 nums 中不包含 t，则返回将 t 按顺序插入数组 nums 中的下标。
// 假设数组中没有相同的数字。例如，输入数组 nums 为[1, 3, 6, 8]，如果目标值 t 为 3，则输出 1；如果 t 为 5，则返回 2。 
public class _1searchInsert {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = right + (left - right) / 2;
            
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums.length;
    }
}
