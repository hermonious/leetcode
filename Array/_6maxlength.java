import java.util.HashMap;
import java.util.Map;




// 输入一个只包含 0 和 1 的数组，返回 0 和 1 的个数相同的最长连续子数组的长度


public class _6maxlength {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sumCnt = new HashMap<>();
        // -1是辅助计算的虚拟索引，专门处理索引 0 开始的有效子数组
        // 在处理前缀和相关问题时很常见，能正确计算子数组长度
        sumCnt.put(0,-1);

        int sum = 0;
        int maxLength = 0;

        for(int i = 0; i < nums.length; ++i) {
            // 把 0 视为 -1 ，1保持不变，那么题目就变成子元素和为0的最长连续子数组的长度
            sum += nums[i] == 0 ? -1 : 1;

            // 若当前前缀和sum已出现过
            if(sumCnt.containsKey(sum)) {
                // 计算子数组长度：当前索引i - 首次出现索引sumCnt.get(sum)
                maxLength = Math.max(maxLength, i - sumCnt.get(sum));
            } else {
                // 首次出现，记录索引 i 到 sumCnt 中
                sumCnt.put(sum, i);
            }
        }
        return maxLength;
    }
}
