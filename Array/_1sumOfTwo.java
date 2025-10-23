// 输入一个递增排序的数组和一个值 target，请问如何在数组中找出 2 个和为 target 的数字并返回它们的下标
// 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。

import java.util.Map;



// 有序，使用双指针
public class _1sumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j && nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[] {i, j};
    }
}



// 无序，使用哈希表
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub)) {
                // 返回 2 个数字的下标
                return new int[] {map.get(sub), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}




