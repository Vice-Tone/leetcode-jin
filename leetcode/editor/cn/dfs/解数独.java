package editor.cn.dfs;

//编写一个程序，通过填充空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// 提示： 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 805 👎 0

class 解数独 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            dfs(board, 0, 0);
        }

        //用boolean返回值代表只要找到一个解即可
        private boolean dfs(char[][] board, int row, int col) {
            int m = 9, n = 9;
            //一行遍历完，进行下一行
            if (col == n) {
                return dfs(board, row + 1, 0);
            }
            //所有行都遍历结束
            if (row == m) {
                return true;
            }
            for (int i = row; i < m; i++) {
                for (int j = col; j < n; j++) {
                    //数字，直接跳过
                    if (board[i][j] != '.') {
                        return dfs(board, i, j + 1);
                    }
                    //空格，用1-9依次尝试
                    for (char ch = '1'; ch <= '9'; ch++) {
                        //不符合数独要求
                        if (!isValid(board, i, j, ch)) {
                            continue;
                        }
                        //这个位置符合要求
                        board[i][j] = ch;
                        //遍历下一个位置
                        if (dfs(board, i, j + 1)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char ch) {

//            for (int i = 0; i < col; i++) {
//                if (board[row][i] == ch) {
//                    return false;
//                }
//            }
//            for (int i = 0; i < row; i++) {
//                if (board[i][col] == ch) {
//                    return false;
//                }
//            }
//            for (int i = 0; i < 9; i++) {
//                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch)
//                    return false;
//            }
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == ch) {
                    return false;
                }
                if (board[i][col] == ch) {
                    return false;
                }
                // 判断 3 x 3 方框是否存在重复
                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}