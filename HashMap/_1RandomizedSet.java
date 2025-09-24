import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// 题目：设计一个数据结构，使如下 3 个操作的时间复杂度都是 O(1)。 
// insert(value)：如果数据集中不包含一个数值，则把它添加到数据集中。 
// remove(value)：如果数据集中包含一个数值，则把它删除。 
// getRandom()：随机返回数据集中的一个数值。 要求数据集中每个数字被返回的概率都相同。 



public class _1RandomizedSet {
    
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;
    

    public _1RandomizedSet() {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(numToLocation.containsKey(val)){
            return false;
        }
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }


    public boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        int location = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size() - 1), location);

        numToLocation.remove(val);
        nums.set(location, nums.get(nums.size() - 1));
        nums.remove(nums.size() - 1);
        return true;
    }


    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }

}
