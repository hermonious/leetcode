import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



// 海洋岛屿地图可以用由 0、1 组成的二维数组表示，水平或竖直方向相连的一组 1 表示一个岛屿，请计算最大的岛屿的面积（即岛屿中 1 的数目）
public class _1maxIsland {

    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {

                    int area = bfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }






    // 1.使用BFS
    private int bfs(int[][] grid, boolean[][] visited, int i, int j) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            area++;

            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return area;
    }




    // 2.使用DFS(栈)
    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;
        int area = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            area++;

            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
                    stack.push(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return area;
    }




    // 2.使用DFS(递归)
    private int dfS(int[][] grid, boolean[][] visited, int i, int j) {
        
        int area = 1;
        visited[i][j] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
                area += dfS(grid, visited, x, y);
            }
        }
        return area;
    }
}