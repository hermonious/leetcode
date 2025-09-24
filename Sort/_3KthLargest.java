import java.util.Random;


// ：请从一个乱序数组中找出第 k 大的数字。
// 例如，数组[3, 1, 2, 4, 5, 5, 6]中第 3 大的数字是 5。




public class _3KthLargest {
    
    
    public int find(int[] nums, int k) {

        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);


        while (index != target) {
            if (index > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(nums, start, end);
        }
        return nums[index];
    }




    

    public int partition(int[] nums, int start, int end) {
        
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);

        int small = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }

        small++;
        swap(nums, small, end);

        return small;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
