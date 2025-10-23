



// 输入 n 和 k，请输出从 1 到 n 中选取 k 个数字组成的所有组合。
// 例如，如果 n 等于 3，k 等于 2，将组成 3 个组合，分别是[1, 2]、[1, 3]和[2, 3]。
import java.util.LinkedList;
import java.util.List;

public class _2allCombinations {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> res = new LinkedList<>();       // 存储所有满足条件的组合
        LinkedList<Integer> combination = new LinkedList<>(); // 当前正在构建的组合
        // 从数字 1 开始尝试选择，初始组合为空
        helper(n, k, 1, combination, res);
        return res;
    }

    /**
     * 回溯辅助函数：递归地构建所有长度为 k 的组合
     * 
     * @param n          可选数字的上界（数字范围是 1 到 n）
     * @param k          目标组合的长度
     * @param i          当前考虑的数字（从 i 到 n 中选择）
     * @param combination 当前正在构建的组合（路径）
     * @param res        存储所有已生成的有效组合的结果列表
     * 
     * 核心思想：对每个数字 i，有两种选择：
     *   1. 不选 i：直接递归处理 i+1
     *   2. 选 i：将 i 加入当前组合，递归处理 i+1；递归返回后，移除 i（回溯）
     */
    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> res) {
        // 终止条件：当前组合长度已达到 k，说明找到一个有效解
        if (combination.size() == k) {
            // 注意：必须添加 combination 的拷贝，否则后续修改会影响已存入的结果
            res.add(new LinkedList<>(combination));
        }
        // 如果当前数字 i 超过 n，则无法继续选择，直接返回（隐含在 else if 中）
        else if (i <= n) {
            // 选择 1：不选当前数字 i
            helper(n, k, i + 1, combination, res);

            // 选择 2：选当前数字 i
            combination.add(i); // 将 i 加入当前组合
            helper(n, k, i + 1, combination, res); // 递归处理下一个数字
            combination.removeLast(); // 回溯：移除刚加入的 i，恢复状态，以便尝试其他分支
        }
    }
}
