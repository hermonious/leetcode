import java.util.LinkedList;
import java.util.Queue;




// 输入一个由 0、1 组成的矩阵 M，请输出一个大小相同的矩阵 D，矩阵 D 中的每个格子是矩阵 M 中对应格子离最近的 0 的距离。水平或竖直方向相邻的两个格子的距离为 1。假设矩阵 M 中至少有一个 0




public class _3updateMatrix {
    
    
    // 1.使用bfs
    public int[][] update(int[][] m) {
        
        int rows = m.length;
        int cols = m[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == 0) {     
                    dists[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            int dist = dists[pos[0]][pos[1]];

            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x >= 0 && x < m.length && y >= 0 && y < m[0].length) {
                    if (dists[x][y] > dist + 1) {
                        dists[x][y] = dist + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return dists;
    }
}
