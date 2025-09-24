



// 在一个排序的数组中，除一个数字只出现一次之外，其他数字都出现了两次，请找出这个唯一只出现一次的数字。
// 例如，在数组[1, 1, 2, 2, 3, 4, 4, 5, 5]中，数字 3 只出现了一次


public class _3singleNum {
    

    public int singleNum(int[] nums) {
        
        int left = 0;
        int right = nums.length / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int i = mid * 2;
            
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 2] > nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }
}
