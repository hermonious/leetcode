




// 给定一个没有重复数字的集合，请找出它的所有全排列。
// 例如，集合[1, 2, 3]有 6 个全排列，分别是[1, 2, 3]、[1, 3, 2]、[2, 1, 3]、[2, 3, 1]、[3, 1, 2]和[3, 2, 1]。
import java.util.LinkedList;
import java.util.List;

public class _5permutation {
    // 排列和组合不同，排列与元素的顺序相关，交换数字能够得到不同的排列
    public List<List<Integer>> permutation(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        helper(nums, 0, res);

        return res;
    }

    // 生成全排列，时间复杂度是 O(n!)
    public void helper(int[] nums, int i, List<List<Integer>> res) {

        if (i == nums.length) {
            List<Integer> permutation = new LinkedList<>();

            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
            
        } else {
            // for 循环逐一用下标为 i 的数字交换它后面的数字。
            // 接着调用递归函数生成排列中下标为 i+1 的数字。
            // 由于之前已经交换了数组中的两个数字，修改了排列的状态，在函数退出之前需要清除对排列状态的修改，因此再次交换之前交换的两个数字
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                helper(nums, i + 1, res);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
