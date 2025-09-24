



// 长度为 n 的数组 org 是数字 1～n 的一个排列，seqs 是若干序列，请判断数组org是否为可以由seqs重建的唯一序列。
// 重建的序列是指seqs 所有序列的最短公共超序列，即 seqs 中的任意序列都是该序列的子序列

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _11reconstruction {
    

    public boolean rebuild(int[] org, List<List<Integer>> seqs) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }

                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }

            for (int i = 0; i < seq.size() - 1; i++) {

                int num1 = seq.get(i);
                int num2 = seq.get(i + 1);

                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);

                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.add(num);
            }
        }

        List<Integer> built = new LinkedList<>();

        while (queue.size() == 1) {
            int num = queue.remove();
            built.add(num);

            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        int[] res = new int[built.size()];
        res = built.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(res, org);
    }
}
