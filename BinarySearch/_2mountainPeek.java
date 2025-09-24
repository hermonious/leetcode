

// 在一个长度大于或等于 3 的数组中，任意相邻的两个数字都不相等。
// 该数组的前若干数字是递增的，之后的数字是递减的，因此它的值看起来像一座山峰。请找出山峰顶部，即数组中最大值的位置。
// 例如，在数组[1, 3, 5, 4, 2]中，最大值是 5，输出它在数组中的下标 2。
public class _2mountainPeek {


    public int findPeek(int[] nums) {

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } 

            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
