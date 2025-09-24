


// 使用优先队列，解决带权图单源最短路径问题






// 给定 n 个节点（编号 1~n），和一个边数组 times[i] = [u, v, w]，表示从 u 到 v 耗时 w。
// 求从节点 k 出发，信号传到所有节点的最短时间。如果无法传到所有节点，返回 -1
import java.util.*;

public class Dijkstra {

    // 边的定义：目标节点 + 权重
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    /**
     * 使用 Dijkstra 算法求从 start 到所有节点的最短距离
     * @param graph 邻接表表示的图，graph[i] 表示从 i 出发的所有边
     * @param n 节点数量（编号 1 ~ n）
     * @param start 起点
     * @return dist[i] 表示从 start 到 i 的最短距离（i 从 1 开始）
     */
    public static int[] dijkstra(List<List<Edge>> graph, int n, int start) {
        // 距离数组，dist[i] 表示从 start 到 i 的最短距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 优先队列（最小堆）：按距离排序 (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, start}); // [距离, 节点]

        // 标记已确定最短距离的节点（可选，用 dist 判断也可）
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];  // 当前距离
            int u = curr[1];  // 当前节点

            // 如果已经处理过，跳过（防止重复入堆）
            if (visited[u]) continue;
            visited[u] = true;

            // 遍历所有邻居
            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int w = edge.weight;

                // 松弛操作：如果通过 u 到 v 更近，就更新
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }




    // 构建图：将边数组转为邻接表
    public static List<List<Edge>> buildGraph(int[][] times, int n) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new Edge(v, w));
        }
        return graph;
    }




    // 示例：LeetCode 743. 网络延迟时间
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = buildGraph(times, n);
        int[] dist = dijkstra(graph, n, k);

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // 有节点不可达
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}