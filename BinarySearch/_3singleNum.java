



// 在一个排序的数组中，除一个数字只出现一次之外，其他数字都出现了两次，请找出这个唯一只出现一次的数字。
// 例如，在数组[1, 1, 2, 2, 3, 4, 4, 5, 5]中，数字 3 只出现了一次
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 将 mid 调整为偶数，确保其指向成对元素的第一个位置
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                // 左侧无异常，唯一元素在右半部分
                left = mid + 2;
            } else {
                // 唯一元素在左半部分（包括 mid）
                right = mid;
            }
        }
        return nums[left];
    }
}
