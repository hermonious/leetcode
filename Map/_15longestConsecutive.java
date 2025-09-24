
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;





// 输入一个无序的整数数组，请计算最长的连续数值序列的长度。
// 例如，输入数组[10, 5, 9, 2, 4, 3]，则最长的连续数值序列是[2, 3, 4, 5]，因此输出 4



public class _15longestConsecutive {
    


    // 使用bfs
    public int longest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            longest = Math.max(longest, bfs(set, iter.next()));
        }

        return longest;
    }


    private int bfs(Set<Integer> set, int num) {
        Queue<Integer> queue = new LinkedList<>();
        set.remove(num);
        int length = 1;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int[] neighbors = new int[] {i - 1, i + 1};

            for (int neighbor: neighbors) {
                if (set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.remove(neighbor);
                    length++;
                }
            }
        }
        return length;
    }









    // 使用并查集
    public int longest2(int[] nums) {

        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();

        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }

        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }

            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }

        return longest;
    }


    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }


    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {

        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);

            int countOfI = counts.get(fatherOfI);
            int countOfJ = counts.get(fatherOfJ);
            counts.put(fatherOfJ, countOfI + countOfJ);
        }
    }
}
