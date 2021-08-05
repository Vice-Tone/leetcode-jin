package editor.cn.slide_window;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 917 👎 0

import java.util.HashMap;

class 最小覆盖子串 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            char[] target = t.toCharArray();

            HashMap<Character, Integer> need = new HashMap<>(16);
            HashMap<Character, Integer> window = new HashMap<>(16);
            int left = 0,right = 0;
            int valid = 0;
            int start,len;
            start = 0;
            len = Integer.MAX_VALUE;

            for (char p : target) {
                need.put(p, need.getOrDefault(p,0)+1);
            }

            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c,window.getOrDefault(c, 0)+1);
                    if (window.get(c).equals(need.get(c))) {
                        ++valid;
                    }
                }

                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if (need.containsKey(d)) {
                        if(window.get(d).equals(need.get(d))){
                            --valid;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}