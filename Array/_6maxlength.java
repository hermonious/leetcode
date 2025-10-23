

// 输入一个只包含 0 和 1 的数组，返回 0 和 1 的个数相同的最长连续子数组的长度
import java.util.HashMap;
import java.util.Map;



// 前缀和
public class _6maxlength {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        // -1是辅助计算的虚拟索引，专门处理索引 0 开始的有效子数组
        // 在处理前缀和相关问题时很常见，能正确计算子数组长度
        // 最巧妙的一点
        map.put(0,-1);

        int sum = 0; 
        int maxL = 0;

        for(int i = 0; i < nums.length; i++) {
            // 把 0 转成 -1 ，1不变，题目就变成了：求元素和为0的最长连续子数组的长度
            sum += (nums[i] == 0 ? -1 : 1);

            // 若当前前缀和sum已出现过
            if(map.containsKey(sum)) {
                maxL = Math.max(maxL, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxL;
    }
}
