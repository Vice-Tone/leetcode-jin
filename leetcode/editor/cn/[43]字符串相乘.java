package editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 698 👎 0

class 字符串相乘 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            //将num2的每一位和num1相乘，并将结果累加
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            String res = "0";
            for (int i = num2.length() - 1; i >= 0; i--) {
                int carry = 0;
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < num2.length(); j++) {
                    sb.append(0);
                }
                int num = num2.charAt(i) - '0';
                for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                    int curNum = j < 0 ? 0 : num1.charAt(j) - '0';
                    int curSum = curNum * num + carry;
                    sb.append(curSum % 10);
                    carry = curSum / 10;
                }
                res = addString(res, sb.reverse().toString());
            }
            return res;
        }

        private String addString(String num1, String num2) {
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