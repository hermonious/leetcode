import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;




// 输入两个数组 equations 和 values，其中，数组 equations 的每个元素包含两个表示变量名的字符串，
// 数组 values 的每个元素是一个浮点数值。如果 equations[i]的两个变量名分别是 Ai和 Bi，那么 Ai/Bi=values[i]。
// 再给定一个数组 queries，它的每个元素也包含两个变量名。对于 queries[j] 的两个变量名 Cj和 Dj，请计算 Cj/Dj的结果。假设任意 values[i]大于 0。如果不能计算，那么返回-1


public class _7calcEquation {
    

    public double[] calculate(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                res[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(graph, from, to, visited);
            }
        }

        return res;
    }


    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            graph.putIfAbsent(var1, new HashMap<>());
            graph.get(var1).put(var2, values[i]);

            graph.putIfAbsent(var2, new HashMap<>());
            graph.get(var2).put(var1, 1.0 / values[i]);
        }

        return graph;
    }




    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {

        if (from.equals(to)) {
            return 1.0;
        }

        visited.add(from);

        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {

            String next = entry.getKey();

            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);

                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }

        visited.remove(from);
        return -1.0;
    }
}
