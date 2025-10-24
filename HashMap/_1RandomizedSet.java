

// 题目：设计一个数据结构，使如下 3 个操作的时间复杂度都是 O(1)。 
// insert(value)：如果数据集中不包含一个数值，则把它添加到数据集中。 
// remove(value)：如果数据集中包含一个数值，则把它删除。 
// getRandom()：随机返回数据集中的一个数值。 要求数据集中每个数字被返回的概率都相同。 

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> arr;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = arr.get(arr.size() - 1);

        // 用最后一个元素覆盖要删除的位置
        map.put(last, idx);
        arr.set(idx, last);

        // 删除
        map.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }

    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
