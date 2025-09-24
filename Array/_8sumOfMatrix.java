// 输入一个二维矩阵，计算给定左上角坐标和右下角坐标的子矩阵的数字之和



// 经典的二维前缀和（矩阵前缀和）实现，核心作用是提前预处理矩阵，将任意子矩阵的和查询从 O (mn) 时间复杂度优化到 O (1)
public class _8sumOfMatrix {
    
    private int[][] sums;//存储二维前缀和
    public _8sumOfMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 设计成 m+1 行、n+1 列是为了避免边界判断：当子矩阵从原矩阵的第 0 行 / 第 0 列开始时，无需处理 “索引为负” 的情况，公式可统一适用
        // sums 数组多一行一列（行索引 0~m，列索引 0~n），其中 sums[0][*] 和 sums[*][0] 均为 0（默认初始化值），作为计算的 “基准边界”
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i <= matrix.length; ++i) {   //i遍历原矩阵的行（0 - m -1）
            int rowSum = 0;//当前行从第 0 列到第 j 列的“行内累加和”
            for(int j = 0; j <= matrix[0].length; ++j) {   //j遍历原矩阵的列（0 - n -1）
                // 累加当前行的元素，更新rowSum
                rowSum += matrix[i][j];


                // sums[i+1][j+1]：原矩阵中 (0,0) 到 (i-1,j) 的矩形和
                // rowSum：原矩阵中第 i 行从 (i,0) 到 (i,j) 的行内和
                // 两者相加，正好覆盖 (0,0) 到 (i,j) 的整个矩形区域，完成前缀和的递推。
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 查询原矩阵中左上角 (row1, col1) 到右下角 (row2, col2) 的子矩阵和，核心是利用预处理好的 sums 数组，通过 “大区域减小区域” 的公式快速计算
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }
}
