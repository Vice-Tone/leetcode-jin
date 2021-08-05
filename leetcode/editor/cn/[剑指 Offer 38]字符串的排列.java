package editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 225 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class 字符串的排列2 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> result = new LinkedList<String>();
        private StringBuilder curPath = new StringBuilder();
        private boolean[] used;

        public String[] permutation(String s) {
            if (s == null) {
                return null;
            }

            used = new boolean[s.length()];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray); // 排序，方便后续的“剪枝”操作

            dfs(charArray, s.length(), 0);
            return result.toArray(new String[result.size()]);
        }

        private void dfs(char[] charArray, int targetLength, int curLength) {
            if (targetLength == curLength) {
                result.add(curPath.toString());
                return;
            }
        /*
            遍历原字符串中的每一个字符，将每个字符都在当前位置设置，并递归计算所有可能结果
        */
            for (int i = 0; i < targetLength; i++) {
                if (!used[i]) {
                    if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) {    // 剪枝：元素相同
                        continue;
                    }
                    used[i] = true;
                    curPath.append(charArray[i]);
                    dfs(charArray, targetLength, curLength+1);
                    curPath.deleteCharAt(curPath.length() - 1);
                    used[i] = false;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}