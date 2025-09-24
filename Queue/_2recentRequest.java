import java.util.LinkedList;
import java.util.Queue;


// 请实现如下类型 RecentCounter，它是统计过去 3000ms 内的请求次数的计数器。
// 该类型的构造函数 RecentCounter 初始化计数器，请求数初始化为 0；
// 函数 ping(int t)在时间 t 添加一个新请求（t 表示以毫秒为单位的时间），并返回过去 3000ms 内（时间范围为[t-3000, t]）发生的所有请求数。
// 假设每次调用函数 ping 的参数 t 都比之前调用的参数值大




public class _2recentRequest {
    

    private Queue<Integer> times;
    private int windowSize;

    public _2recentRequest() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        times.offer(t);
        while (times.peek() < t - windowSize) {
            times.poll();
        }
        return times.size();
    }
}
