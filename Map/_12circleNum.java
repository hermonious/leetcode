import java.util.LinkedList;
import java.util.Queue;

public class _12circleNum {
    



    // 1.使用bfs
    public int circle(int[][] f) {

        boolean[] visited = new boolean[f.length];
        int res = 0;

        for (int i = 0; i < f.length; i++) {
            if (!visited[i]) {
                findCircle(f, visited, i);
                res++;
            }
        }
        return res;
    }


    private void findCircle(int[][] f, boolean[] visited, int i) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int t = queue.remove();
            for (int friend = 0; friend < f.length; friend++) {
                if (f[t][friend] == 1 && !visited[friend]) {
                    queue.add(friend);
                    visited[friend] = true;
                } 
            }
        }
    }






    // 使用并查集
    public int circle2(int[][] f) {

        int[] fathers = new int[f.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }

        int count = f.length;
        for (int i = 0; i < f.length; i++) {
            for (int j = i + 1; j < f.length; j++) {
                if (f[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }


    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }


    private boolean union(int[] fathers, int i, int j) {

        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }
}
