package editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 771 👎 0

import java.util.ArrayList;
import java.util.List;

class 螺旋矩阵 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>();
            }
            int m = matrix.length;
            int n = matrix[0].length;
            ArrayList<Integer> list = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            //方向数组
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            //确定往哪个方向走
            int directionIndex = 0;
            int row = 0, col = 0;
            for (int i = 0; i < m * n; i++) {
                list.add(matrix[row][col]);
                visited[row][col] = true;
                int nextRow = row + directions[directionIndex][0];
                int nextCol = col + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                col += directions[directionIndex][1];
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}