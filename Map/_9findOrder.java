import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _9findOrder {

    public int[] findOrder(int numCourses, int[][] pres) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        int[] inDegrees = new int[numCourses];

        for (int[] pre : pres) {
            graph.get(pre[1]).add(pre[0]);
            inDegrees[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new LinkedList<>();
        while (!queue.isEmpty()) {
            int course = queue.remove();
            order.add(course);

            for (int next : graph.get(course)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return order.size() == numCourses ? order.stream().mapToInt(i -> i).toArray() : new int[0];
    }

}

