package editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 380 👎 0

class 字符串相加 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int m = num1.length() - 1, n = num2.length() - 1, add = 0;
            StringBuilder sb = new StringBuilder();
            while (m >= 0 || n >= 0 || add != 0) {
                int val1 = m >= 0 ? num1.charAt(m) - '0' : 0;
                int val2 = n >= 0 ? num2.charAt(n) - '0' : 0;
                int val = val1 + val2 + add;
                sb.append(val % 10);
                add = val / 10;
                m--;
                n--;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}