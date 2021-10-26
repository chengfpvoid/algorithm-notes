package org.cheng.algo.matrixprefixsum.lc304;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 *
 * NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 * 输入:
 * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
 * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
 * 输出:
 * [null, 8, 11, 12]
 *
 * 解释:
 * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *  * Your NumMatrix object will be instantiated and called as such:
 *  * NumMatrix obj = new NumMatrix(matrix);
 *  * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 *
 *
 */

public class NumMatrix {

    private int[][] s;


    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        this.s = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++ ) {
                s[i][j] = getSum(i -1,j) + getSum(i,j-1) - getSum(i-1,j-1) + matrix[i][j];
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return getSum(row2, col2) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);

    }

    private int getSum(int i , int j ) {
        if (i >= 0 && j >= 0) {
            return s[i][j];
        }
        return 0;
    }
}
