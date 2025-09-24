


// 输入两个数组 arr1 和 arr2，其中数组 arr2 中的每个数字都唯一，并且都是数组 arr1 中的数字。
// 请将数组 arr1 中的数字按照数组 arr2 中的数字的相对顺序排序。
// 如果数组 arr1 中的数字在数组 arr2 中没有出现，那么将这些数字按递增的顺序排在后面。
// 假设数组中的所有数字都在 0 到 1000 的范围内。
// 例如，输入的数组 arr1 和 arr2 分别是[2, 3, 3, 7, 3, 9, 2, 1, 7, 2]和[3, 2, 1]，则数组 arr1 排序之后为[3, 3, 3, 2, 2, 2, 1, 7, 7, 9]。




public class _2relativeSorting {
    


    public int[] relativeSorting(int[] a, int[] b) {
        int[] counts = new int[100];

        for (int num : a) {
            counts[num]++;
        }

        int i = 0;

        for (int num : b) {
            while (counts[num] > 0) {
                a[i++] = num;
                counts[num]--;
            }
        }

        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                a[i++] = num;
                counts[num]--;
            }
        }

        return a;
    }
}
