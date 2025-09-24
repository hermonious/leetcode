import java.util.Random;




public class quicksort {
        
    
    // 递归
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            
            int pivot = partition(nums, start, end);

            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
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
