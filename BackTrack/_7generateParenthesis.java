import java.util.LinkedList;
import java.util.List;



// 输入一个正整数 n，请输出所有包含 n 个左括号和 n 个右括号的组合，要求每个组合的左括号和右括号匹配。
// 例如，当 n 等于 2 时，有两个符合条件的括号组合，分别是"(())"和"()()"。



public class _7generateParenthesis {
    
    public List<String> generate(int n) {
        List<String> res = new LinkedList<>();
        helper(n, n, "", res);

        return res;
    }



    // left 表示还需要生成左括号的数目，参数 right 表示还需要生成右括号的数目。
    // 每生成一个左括号，参数 left 减 1；每生成一个右括号，参数 right 减 1。
    // 当参数 left 和 right 都等于 0 时，一个完整的括号组合已经生成。 
    private void helper(int left, int right, String parenthesis, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(parenthesis);
            return;
        }

        // 在生成一个括号时，只要已经生成的左括号的数目少于 n 个（即参数left 大于 0）就可能生成一个左括号
        if (left > 0) {
            helper(left - 1, right, parenthesis + "(", res);
        }

        // 只要已经生成的右括号的数目少于已经生成的左括号的数目（即参数 left 小于 right）就可能生成一个右括号
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", res);
        }
    }
}
