import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _13nearBy {




    // O(nlogk)的解法
    public boolean nearBy(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long lower = set.floor(Long.valueOf(nums[i]));
            if (lower != null && lower >= (long)nums[i] - t) {
                return true;
            }

            Long upper = set.ceiling(Long.valueOf(nums[i]));
            if (upper != null && upper <= (long)nums[i] + t) {
                return true;
            }

            set.add((long)nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }







    
    // O(n)的解法
    public boolean nearBy2(int[] nums, int k, int t) {
        Map<Integer, Integer> buckets = new HashMap<>();
        int size = t + 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucket(num, size);

            if (buckets.containsKey(id) 
                || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num) 
                || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
                return true;
            }
            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucket(nums[i - k], size));
            }
        }
        return false;
    }
    private int getBucket(int num, int size){
        return num >= 0 ? num / size : (num + 1) / size - 1;
    }
}
