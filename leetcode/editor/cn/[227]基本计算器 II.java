package editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 
// 👍 460 👎 0

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class 基本计算器II {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            //维护优先级
            Map<Character, Integer> map = new HashMap<Character, Integer>(16);
            map.put('-', 1);
            map.put('+', 1);
            map.put('*', 2);
            map.put('/', 2);
            map.put('%', 2);
            map.put('^', 3);
            s = s.replace(" ", "");
            char[] chars = s.toCharArray();
            Deque<Integer> nums = new LinkedList<>();
            Deque<Character> ops = new LinkedList<>();
            nums.push(0);

            for (int i = 0; i < s.length(); i++) {
                char c = chars[i];
                if (c == '(') {
                    ops.push(c);
                } else if (c == ')') {
                    //计算到最近的一个左括号为止
                    while (!ops.isEmpty()) {
                        if (ops.peek() != '(') {
                            calc(nums, ops);
                        } else {
                            ops.pop();
                            break;
                        }
                    }
                } else {
                    if (Character.isDigit(c)) {
                        //考虑到有两位数以上的情况
                        //从i开始取出一个完整的数字
                        int num = 0;
                        int j = i;
                        while (j < s.length() && Character.isDigit(chars[j])) {
                            num = num * 10 + (chars[j] - '0');
                            j++;
                        }
                        nums.push(num);
                        i = j - 1;
                    } else {
                        //如果是个负数 比如 1-(-2)
                        if (i > 0 && (chars[i - 1] == '(' || chars[i - 1] == '-' || chars[i - 1] == '+')) {
                            nums.push(0);
                        }
                        //有新的操作数要入栈了
                        while (!ops.isEmpty() && ops.peek() != '(') {
                            char prev = ops.peek();
                            //ops栈顶操作符优先级大于等于c
                            if (map.get(prev) >= map.get(c)) {
                                calc(nums, ops);
                            } else {
                                break;
                            }
                        }
                        ops.push(c);
                    }
                }
            }
            while (!ops.isEmpty() && ops.peekLast() != '(') {
                calc(nums, ops);
            }
            return nums.peek();
        }

        private void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) {
                return;
            }
            int b = nums.poll();
            int a = nums.poll();
            char op = ops.pop();
            int res = 0;
            if (op == '+') {
                res = a + b;
            } else if (op == '-') {
                res = a - b;
            } else if (op == '*') {
                res = a * b;
            } else if (op == '/') {
                res = a / b;
            } else if (op == '^') {
                res = (int) Math.pow(a, b);
            } else if (op == '%') {
                res = a % b;
            }
            nums.push(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}