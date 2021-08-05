package editor.cn.dfs;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 814 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class N皇后 {
    public static void main(String[] args) {
        List<List<String>> lists = new Solution().solveNQueens(4);

        System.out.println(lists.toString());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        private List<List<String>> res = new LinkedList<>();

        public List<List<String>> solveNQueens(int n) {
            List<String> board = new ArrayList<>();

            dfs(board, 0, n);

            return res;
        }

        private void dfs(List<String> board, int row, int n) {
            if (row == n) {
                res.add(new ArrayList<>(board));
                return;
            }
            for (int col = 0; col < n; col++) {
                //判断当前位置能否放置皇后
                if (!isValid(board, row, col, n)) {
                    continue;
                }
                //做选择
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < col; i++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int i = col + 1; i < n; i++) {
                    sb.append(".");
                }

                board.add(sb.toString());

                dfs(board, row + 1, n);

                board.remove(board.size() - 1);
            }
        }

        //检查上下左右，斜对角有没有皇后
        private boolean isValid(List<String> board, int row, int col, int n) {
            //判断竖直方向
            for (int i = 0; i < row; i++) {
                if (board.get(i).charAt(col) == 'Q') {
                    return false;
                }
            }
            //判断右上
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            //判断左上
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).charAt(j) == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}