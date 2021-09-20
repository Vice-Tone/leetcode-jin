package editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1686 👎 0

import java.util.ArrayList;
import java.util.List;

class 括号生成 {
    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        ArrayList<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {

            StringBuilder sb = new StringBuilder();

            String[] tem = new String[]{"(", ")"};

            dfs(n, n, tem, sb);

            return res;

        }

        /**
         *
         * @param left 左括号个数
         * @param right 右括号个数
         * @param tem
         * @param sb
         */
        private void dfs(int left, int right, String[] tem, StringBuilder sb) {

            if (left > right) {
                return;
            }
            if (left < 0 || right < 0) {
                return;
            }
            if (left == 0 && right == 0) {
                res.add(sb.toString());
                return;
            }

            //加入左括号
            sb.append(tem[0]);
            dfs(left - 1, right, tem, sb);
            sb.deleteCharAt(sb.length() - 1);

            //加入右括号
            sb.append(tem[1]);
            dfs(left, right - 1, tem, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}