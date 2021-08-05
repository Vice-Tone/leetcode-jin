package editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 906 👎 0

class 单词搜索 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m;
        int n;
//        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || board[0].length == 0) {
                return false;
            }
            m = board.length;
            n = board[0].length;
//            ArrayList<Character> res = null;
//            visited = new boolean[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    visited[i][j] = false;
//                }
//            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                    res = new ArrayList<>();
                    boolean flag = dfs(board, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int k) {
            if (i < 0 || i >= m || j < 0 | j >= n || board[i][j] != word.charAt(k)) {
                return false;
            }
            if (k == word.length() - 1) {
                return true;
            }
            board[i][j] = '\0';
            boolean res = dfs(board, i, j + 1, word, k + 1)
                    || dfs(board, i, j - 1, word, k + 1)
                    || dfs(board, i + 1, j, word, k + 1)
                    || dfs(board, i - 1, j, word, k + 1);
            board[i][j] = word.charAt(k);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}