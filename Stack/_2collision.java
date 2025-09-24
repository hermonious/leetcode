import java.util.Stack;

// 输入一个表示小行星的数组，数组中每个数字的绝对值表示小行星的大小，
// 数字的正负号表示小行星运动的方向，正号表示向右飞行，负号表示向左飞行。
// 如果两颗小行星相撞，那么体积较小的小行星将会爆炸最终消失，体积较大的小行星不受影响。
// 如果相撞的两颗小行星大小相同，那么它们都会爆炸消失。飞行方向相同的小行星永远不会相撞。求最终剩下的小行星



public class _2collision {
    

    public int[] collision(int[] stones) {
        Stack<Integer> stack = new Stack<>();

        for (int stone : stones) {
            while (!stack.empty() && stack.peek() > 0 && stack.peek() < -stone) {
                stack.pop();
            }

            if (!stack.empty() && stack.peek() == -stone) {
                stack.pop();
            } else if (stone > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(stone);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
