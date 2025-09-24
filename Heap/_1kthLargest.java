
import java.util.PriorityQueue;


// 请设计一个类型 KthLargest，它每次从一个数据流中读取一个数字，并得出数据流已经读取的数字中第 k（k≥1）大的数字。
// 该类型的构造函数有两个参数：一个是整数 k，另一个是包含数据流中最开始数字的整数数组 nums（假设数组 nums 的长度大于 k）。
// 该类型还有一个函数 add，用来添加数据流中的新数字并返回数据流中已经读取的数字的第 k 大数字。




public class _1kthLargest {
    

    // 使用最小堆
    // 当 n 非常大时，内存可能不能容纳数据流中的所有数字。
    // 但使用最小堆之后，内存中只需要保存 k 个数字，空间效率非常高。 
    // 最小堆的堆顶元素就是第 k 大的数字。
    private PriorityQueue<Integer> minHeap;
    private int k;

    public _1kthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
