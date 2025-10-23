import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



// 输入一个数组，找出数组中所有和为 0 的 3 个数字的三元组，不可重复



// 尾部添加无扩容的特性 完美匹配题目对结果集的操作需求
// 使用List<Integer>来存储一个三元组，再加一层List<>来存储所有三元组
public class _2threeSumEqual0 {
    public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> res = new LinkedList<>();

        // 至少要3个元素才会有三元组的可能
        if(nums.length >= 3) {
            Arrays.sort(nums);

            int i = 0;
            
            // 极限情况下，确保i之后至少有 2 个元素，即 j，k 的位置，才能构成三元组
            while(i < nums.length - 2) {
                twoSum(nums,i,res);

                // 记录当前的 nums[i]，用于后续跳过所有重复的 nums[i]
                int temp = nums[i];
                while(i < nums.length - 2 && nums[i] == temp) {
                    i++;
                }
            }
        }
        return res;
    }




    // 思路和sumOfTwo.java类似
    // i已经被固定了，所以在 i 不变的基础上，在 i 右边找出两个数字 j 和 k
    // j是左指针，k是右指针
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            if(nums[i] + nums[j] + nums[k] == 0) {
                // 使用Arrays.asList()来创建一个List<Integer>
                // 使用List.add()，将这个List放入结果集合里面，因为res的类型是List<List<Integer>>
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                // 记录当前的 nums[j]，用于后续跳过所有重复的 nums[j]
                int temp = nums[j];
                while(j < k && nums[j] == temp) {
                    ++j;
                }
            }
            else if(nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            }
            else {
                k--;
            }
        }
    }
}
