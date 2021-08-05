package editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1634 👎 0

class 最长公共前缀 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                minLen = Math.min(str.length(), minLen);
            }
            int size = strs.length;
            int index = -1;
            for (int i = 0; i < minLen; i++) {
                char first = strs[0].charAt(i);
                int j = 1;
                for (; j < size; j++) {
                    if (strs[j].charAt(i) != first) {
                        break;
                    }
                }
                if (j == size) {
                    index++;
                } else {
                    break;
                }
            }
            return index == -1 ? "" : strs[0].substring(0, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}