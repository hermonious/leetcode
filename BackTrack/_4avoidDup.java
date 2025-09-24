


// 给定一个可能包含重复数字的整数集合，请找出所有元素之和等于某个给定值的所有组合。
// 输出中不得包含重复的组合。例如，输入整数集合[2, 2, 2, 4, 3, 3]，元素之和等于 8 的组合有 2 个，分别是[2, 2, 4]和[2, 3, 3]

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4avoidDup {
    


    // 最大的不同在于输入的集合中有重复的数字但输出不得包含重复的组合
    // 避免重复的组合的方法是当在某一步决定跳过某个值为 m 的数字时，跳过所有值为 m 的数字
    // 为了方便跳过后面所有值相同的数字，可以将集合中的所有数字排序，把相同的数字放在一起，这样方便比较数字。
    // 当决定跳过某个值的数字时，可以按顺序扫描后面的数字，直到找到不同的值为止


    public List<List<Integer>> noDup(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        help(nums, target, 0, combination, res);

        return res;
    }



    private void help(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> res) {

        if (target == 0) {
            res.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            help(nums, target, getNext(nums, i), combination, res);

            combination.add(nums[i]);
            help(nums, target - nums[i], i + 1, combination, res);
            combination.removeLast();
            
        }
    }


    private int getNext(int[] nums, int index) {

        int next = index;

        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        return next;
    }
}
