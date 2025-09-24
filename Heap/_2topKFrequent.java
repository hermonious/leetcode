
import java.util.*;


// 请找出数组中出现频率最高的 k 个数字


public class _2topKFrequent {
    


    // 哈希表 numToCount 用来统计数字出现的频率，它的键是数组中的数字，值是数字在数组中出现的次数。
    // 最小堆 minHeap 中的每个元素是哈希表中从数字到频率的映射。由于最小堆比较的是数字的频率，因此调用构造函数创建 minHeap 设置的比较规则是比较哈希表中映射的值，也就是数字的频率。 
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();

        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {

            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            res.add(entry.getKey());
        }
        return res;
    }
}
