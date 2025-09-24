import java.util.LinkedList;
import java.util.List;



// 一个有向无环图由 n 个节点（标号从 0 到 n-1，n≥2）组成，请找出从节点 0 到节点 n-1 的所有路径。
// 图用一个数组 graph 表示，数组的graph[i]包含所有从节点 i 能直接到达的节点



public class _6allPath {
    


    public List<List<Integer>> allPath (int[][] graph) {

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, graph, path, res);

        return res;
    }

    private void dfs(int source, int[][] graph, List<Integer> path, List<List<Integer>> res) {

        path.add(source);
        if (source == graph.length - 1) {
            res.add(new LinkedList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, res);

            }
        }
        path.remove(path.size() - 1);
    }
}
