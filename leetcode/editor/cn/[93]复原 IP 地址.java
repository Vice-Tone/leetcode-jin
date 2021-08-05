package editor.cn;

//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 572 👎 0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class 复原IP地址 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> res = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            if (s == null || s.length() < 4 || s.length() > 12) {
                return res;
            }
            Deque<String> track = new ArrayDeque<>(4);
            int splitTime = 0;
            int pos = 0;
            dfs(s, splitTime, pos, track);
            return res;
        }

        /**
         * @param s         路径选择列表
         * @param splitTime 分割次数
         * @param pos       当前位置
         * @param track     当前路径
         */
        private void dfs(String s, int splitTime, int pos, Deque<String> track) {
            if (pos == s.length()) {
                //达到ip四位条件
                if (track.size() == 4) {
                    res.add(String.join(",", track));
                }
                return;
            }
            //剩下的太短或太长
            if (s.length() - pos < (4 - splitTime) || s.length() - pos > 3 * (4 - splitTime)) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (pos + i >= s.length()) {
                    break;
                }
                //判断从s的pos位置开始截取i个字符串的数字是否满足ip地址要求
                int result = judge(s, pos, pos+i);
                if (result != -1) {
                    //满足要求
                    track.addLast(s.substring(pos, pos + i + 1));
                    dfs(s, splitTime + 1, pos + i + 1, track);
                    track.removeLast();
                }
            }
        }

        private int judge(String s, int left, int right) {
            if (right - left + 1 > 1 && s.charAt(left) == '0') {
                return -1;
            }
            int res = Integer.parseInt(s.substring(left, right+1));
            if (res > 255) {
                return -1;
            } else {
                return res;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}