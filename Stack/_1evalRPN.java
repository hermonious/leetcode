import java.util.Stack;

// 使用栈，实现逆波兰表达式求值
public class _1evalRPN {
    

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch(token) {
                case "+":
                case "-":
                case "*":
                case "/":

                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculate(num1,num2,token));
            default:
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }



    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
