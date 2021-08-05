package editor.cn.matrix;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 213 👎 0

class 顺时针打印矩阵 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] visited = new boolean[m][n];
            int total = m * n;
            int[] path = new int[total];
            //方向数组，右，下，左，上
            int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            int row = 0, col = 0;
            for (int i = 0; i < total; i++) {
                path[i] = matrix[row][col];
                visited[row][col] = true;
                int nextRow = row + direction[directionIndex][0];
                int nextCol = col + direction[directionIndex][1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row = row + direction[directionIndex][0];
                col = col + direction[directionIndex][1];
            }
            return path;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}