

// 输入一个整数数组和一个整数 k，返回数组中数字之和等于 k 的连续子数组的个数
import java.util.HashMap;
import java.util.Map;



// 前缀和数组
public class _5subSum {
    public int subarraySum(int[] nums, int k) {
        // 记录前缀和的出现次数
        Map<Integer,Integer> map = new HashMap<>();
        // 初始化前缀和为0的情况，出现次数为1
        map.put(0,1);

        int sum = 0;//记录当前遍历位置的前缀和
        int cnt = 0;//记录符合条件的子数组数量


        // 前缀和数组：sum[i] == nums[0] + nums[1] + ... + nums[i-1]
        // 前缀和数组的任意连续子数组nums[j...i - 1]的和 == nums[j] + nums[j+1] + ... + nums[i-1] == sum[i] - sum[j]
        // 如果这个子数组和为k，那么sum[i] - sum[j] == k，即sum[j] == sum[i] - k
        for(int num : nums) {
            sum += num;
            // 查找有多少个前缀和等于 sum - k的子数组
            cnt += map.getOrDefault(sum - k, 0);
            // 将当前前缀和sum[i]存入map，更新出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}


