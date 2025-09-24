import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// 如果能将一个图中的节点分成 A、B 两个部分，使任意一条边的一个节点属于 A 而另一个节点属于 B，那么该图就是一个二分图
// 输入一个由数组 graph 表示的图，graph[i]中包含所有和节点 i 相邻的节点，请判断该图是否为二分图




public class _2isBipartite {
    public boolean isBipartite(int[][] graph) {
        
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);

        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!bfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }








    // 1.使用bfs
    private boolean bfs(int[][] graph, int[] colors, int i, int color) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;

        while (!queue.isEmpty()) {
            int node = queue.remove();

            for (int neighbor : graph[node]) {
                if (colors[neighbor] >= 0) {
                    if (colors[neighbor] == colors[node]) {
                        return false;
                    }
                } else {
                    colors[neighbor] = 1 - colors[node];
                    queue.add(neighbor);
                }
            }
        }
        return true;
    }








    // 2.使用dfs
    private boolean dfs(int[][] graph, int[] colors, int i, int color) {
        
        if (colors[i] >= 0) {
            return colors[i] == color;
        }

        colors[i] = color;

        for (int neighbor : graph[i]) {
            if (!dfs(graph, colors, neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
