import java.util.LinkedList;
import java.util.List;



// 输入 n 和 k，请输出从 1 到 n 中选取 k 个数字组成的所有组合。
// 例如，如果 n 等于 3，k 等于 2，将组成 3 个组合，分别是[1, 2]、[1, 3]和[2, 3]。



public class _2allCombinations {
    

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(n, k, 1, combination, res);

        return res;
    }


    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> res) {

        if (combination.size() == k) {
            res.add(new LinkedList<>(combination));
        } else if (i <= n) {
            helper(n, k, i + 1, combination, res);

            combination.add(i);
            helper(n, k, i + 1, combination, res);
            combination.removeLast();
        }
    }
}
