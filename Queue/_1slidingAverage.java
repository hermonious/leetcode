import java.util.LinkedList;
import java.util.Queue;



// 请实现如下类型 MovingAverage，计算滑动窗口中所有数字的平均值，
// 该类型构造函数的参数确定滑动窗口的大小，每次调用成员函数 next 时都会在滑动窗口中添加一个整数，并返回滑动窗口中所有数字的平均值


public class _1slidingAverage {

    private Queue<Integer> nums;
    private int cap;
    private int sum;


    public _1slidingAverage(int size) {
        nums = new LinkedList<>();
        cap = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > cap) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }
}


