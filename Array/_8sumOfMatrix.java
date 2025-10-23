// 输入一个二维矩阵，计算给定左上角坐标和右下角坐标的子矩阵的数字之和



// 输入一个二维矩阵，计算给定左上角坐标和右下角坐标的子矩阵的数字之和
// 经典的二维前缀和（矩阵前缀和）

public class _8sumOfMatrix {
    
    private int[][] sums; // 存储二维前缀和
    
    public _8sumOfMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            sums = new int[0][0];
            return;
        }
        // 设计成 m+1 行、n+1 列是为了避免边界判断：当子矩阵从原矩阵的第 0 行 / 第 0 列开始时，
        // 无需处理 “索引为负” 的情况，公式可统一适用
        // sums 数组多一行一列（行索引 0~m，列索引 0~n），其中 sums[0][*] 和 sums[*][0] 均为 0（默认初始化值），
        // 作为计算的 “基准边界”
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        
        // 注意：i 和 j 只遍历原矩阵的有效范围
        for (int i = 0; i < m; i++) {          // i 遍历原矩阵的行（0 到 m-1）
            int rowSum = 0; // 当前行从第 0 列到第 j 列的“行内累加和”
            
            for (int j = 0; j < n; j++) {      // j 遍历原矩阵的列（0 到 n-1）
                // 累加当前行的元素，更新 rowSum
                rowSum += matrix[i][j];

                // sums[i+1][j+1]：表示原矩阵中 (0,0) 到 (i,j) 的矩形区域和
                // sums[i][j+1]：上方所有行到第 j 列的和
                // rowSum：当前第 i 行从 0 到 j 的和
                // 两者相加，正好覆盖 (0,0) 到 (i,j) 的整个矩形区域
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 查询原矩阵中左上角 (row1, col1) 到右下角 (row2, col2) 的子矩阵和
        // 核心是利用预处理好的 sums 数组，通过 “大区域减小区域” 的公式快速计算
        return sums[row2 + 1][col2 + 1] 
             - sums[row2 + 1][col1] 
             - sums[row1][col2 + 1] 
             + sums[row1][col1];
    }
}
