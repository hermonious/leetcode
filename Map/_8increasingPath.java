



// 输入一个整数矩阵，请求最长递增路径的长度。矩阵中的路径沿着上、下、左、右 4 个方向前行

public class _8increasingPath {
    


    public int longest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }


        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[][] lens = new int[len1][len2];
        int longest = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {

                int leng = dfs(matrix, lens, i, j);
                longest = Math.max(longest, leng);
            }
        }
        return longest;
    }



    private int dfs(int[][] matrix, int[][] lens, int i, int j) {
        if (lens[i][j] != 0) {
            return lens[i][j];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{-1, 0},{0, -1},{1, 0},{0, 1}};
        int length = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {

                int path = dfs(matrix, lens, x, y);
                length = Math.max(path + 1, length);
            }
        }

        lens[i][j] = length;
        return length;
        
    }
}
