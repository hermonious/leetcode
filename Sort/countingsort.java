



// 计数排序是一种线性时间的整数排序算法。
// 如果数组的长度为 n，整 数范围（数组中最大整数与最小整数的差值）为 k，对于 k 远小于 n 的场景（如对某公司所有员工的年龄排序），那么计数排序的时间复杂度优于其他基于比较的排序算法（如归并排序、快速排序等）。 
public class countingsort {
    

    public int[] sort(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] counts = new int[max - min + 1]; 

        for (int num : nums) {
            counts[num - min]++;
        }

        int i = 0;
        for (int num = min; num <= max; num++) {
            while (counts[num - min] > 0) {
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
    }
}
