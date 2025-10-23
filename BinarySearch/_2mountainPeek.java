

// 在一个长度大于或等于 3 的数组中，任意相邻的两个数字都不相等。
// 该数组的前若干数字是递增的，之后的数字是递减的，因此它的值看起来像一座山峰。请找出山峰顶部，即数组中最大值的位置。
// 例如，在数组[1, 3, 5, 4, 2]中，最大值是 5，输出它在数组中的下标 2。
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                // 当前处于下坡，峰顶在左侧
                right = mid - 1;
            } else {
                // 当前处于上坡，峰顶在右侧
                left = mid + 1;
            }
        }
        // 根据题意，输入保证是有效山脉数组，此行理论上不会执行
        return -1;
    }
}
