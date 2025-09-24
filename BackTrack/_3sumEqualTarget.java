import java.util.LinkedList;
import java.util.List;



// 给定一个没有重复数字的正整数集合，请找出所有元素之和等于某个给定值的所有组合。同一个数字可以在组合中出现任意次。
// 例如，输入整数集合[2, 3, 5]，元素之和等于 8 的组合有 3 个，分别是[2, 2, 2, 2]、[2, 3, 3]和[3, 5



public class _3sumEqualTarget {
    
    public List<List<Integer>> combine(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(nums, target, 0, combination, res);

        return res;
    }


    //  target 是组合 combination 中元素之和的目标值。
    // 每当在组合中添加一个数字时，就从 target 中减去这个数字。
    // 当 target 等于 0 时，组合中的所有元素之和正好等于 target，因此也就找到了一个符合条件的组合。 
    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            helper(nums, target, i + 1, combination, res);

            combination.add(nums[i]);
            helper(nums, target, i + 1, combination, res);
            combination.removeLast();
        }
    }
}
