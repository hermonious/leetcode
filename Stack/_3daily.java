import java.util.Stack;



// 输入一个数组，它的每个数字是某天的温度。请计算每天需要等几天才会出现更高的温度
public class _3daily {
    
    public int[] daily(int[] tmp) {
        int[] res = new int[tmp.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.empty() && tmp[i] > tmp[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}
