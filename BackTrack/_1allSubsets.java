



// 输入一个不含重复数字的数据集合，请找出它的所有子集。
// 例如，数据集合[1, 2]有 4 个子集，分别是[]、[1]、[2]和[1, 2]

import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 即使 nums 为空，也应返回包含一个空子集的结果 [[]]
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    // 第 1 个参数是数组 nums，它包含输入集合的所有数字。可以逐一从集合中取出一个数字并选择是否将该数字添加到子集中
    // 第 2 个参数 index 是当前取出的数字在数组 nums 中的下标
    // 第 3 个参数 subset 是当前子集
    // 第 4 个参数 res 是所有已经生成的子集
    // 不考虑将该数字添加到子集中时，不对子集进行任何操作，只需要调用递归函数 helper 处理数组 nums 中的下一个数字（下标增加 1）
    // 考虑将该数字添加到子集中后，调用递归函数处理数组 nums 中的下一个数字（下标增加 1）。等递归函数执行完成之后，函数 helper 也执行完成，接下来将回到前一个数字的函数调用处继续执行。
    // 此时将回溯到父节点，以便尝试父节点的其他选项。在回溯到父节点之前，应该清除已经对子集状态进行的修改。此前在子集 subset 中添加了一个数字，此时应该将它删除
    private void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            // 当 index 等于数组 nums 的长度时，表示数组中的所有数字都已经处理过，因此已经生成了一个子集，于是将子集 subset 添加到 res 中
            // 需要注意的是，在 res 中添加的是 subset 的一个拷贝，而不是 subset 本身。
            res.add(new ArrayList<>(subset));
            
        } else {
            // 选择 1：不选当前元素
            helper(nums, index + 1, subset, res);
            
            // 选择 2：选当前元素
            subset.add(nums[index]);
            helper(nums, index + 1, subset, res);
            subset.remove(subset.size() - 1); // 回溯：移除刚加入的元素
        }
    }
}
