import java.util.Arrays;



// 归并排序也是一种基于分治法的排序算法。为了排序长度为 n 的数组，需要先排序两个长度为 n/2 的子数组，然后合并这两个排序的子数组，于是整个数组也就排序完毕。
public class mergesort {
    


    // 迭代法
    public int[] sort(int[] nums) {

        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];

        for (int seg = 1; seg < length; seg += seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start;
                int j = mid;
                int k = start;

                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] <= src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }

            int[] temp = src;
            src = dst;
            dst = temp;
        }

        return src;
    }









    // 递归实现
    public int[] sorting(int[] nums) {

        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start + 1 >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(dst, src, start, mid);
        mergeSort(dst, src, mid, end);

        int i = start;
        int j = mid;
        int k = start;

        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] <= src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }
}
