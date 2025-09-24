import java.util.*;



// 给定两个递增排序的整数数组，从两个数组中各取一个数字 u 和 v 组成一个数对(u, v)，请找出和最小的 k 个数对




public class _3kSmallerPairs {
    


    // 使用最大堆
    // maxHeap 是一个最大堆，它的每个元素都是一个长度为 2 的数组，表示一个数对。
    // 每个数对的第 1 个数字来自数组 nums1，第 2 个数字来自数组 nums2。由于希望和最大的数对位于堆的顶部，因此在PriorityQueue 的构造函数中传入的比较规则比较的是两个数对之和。
    // 可以用一个 lambda 表达式定义比较规则，它的参数是两个数对 p1 和 p2。
    // 由于需要一个最大堆，和默认的最小堆的比较规则相反，因此 lambda 表达式的返回值是用数对 p2 之和 - 数对 p1 之和。
    public List<List<Integer>> kSmallerPairs(int[] nums1, int[] nums2, int k) {

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        for (int i = 0; i <Math.max(k, nums1.length); i++) {
            for (int j = 0; j <Math.max(k, nums2.length); j++) {
                
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if (root[0] + root[1] > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    } else {
                        maxHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }

        List<List<Integer>> res = new LinkedList<>();

            while (!maxHeap.isEmpty()) {
                int[] pair = maxHeap.poll();
                res.add(Arrays.asList(pair[0], pair[1]));
            }
            return res;
    }







    // 使用最小堆

    public List<List<Integer>> kSmallerPairs2(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums1[a[1]] - nums2[b[0]] - nums2[b[1]]);

        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        while (!minHeap.isEmpty() && k > 0) {
            int[] pair = minHeap.poll();
            res.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));

            if (pair[1] + 1 < nums2.length) {
                minHeap.offer(new int[]{pair[0], pair[1] + 1});
            }
            k--;
        }
        return res;
    }
}
