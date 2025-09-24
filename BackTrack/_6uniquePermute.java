import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class _6uniquePermute{



    // 给定一个包含重复数字的集合，请找出它的所有全排列。
    // 例如，集合[1, 1, 2]有 3 个全排列，分别是[1, 1, 2]、[1, 2, 1]和[2, 1, 1]
    
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);

        return res;
    }


    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            res.add(permutation);
        } else {

            // 使用了一个 HashSet，用来保存已经交换到排列下标为 i 的位置的所有值。只有当一个数值之前没有被交换到第 i 位时才做交换，否则直接跳过。 
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);

                    swap(nums, i, j);
                    helper(nums, i + 1, res);
                    swap(nums, i, j);
                }
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