package editor.cn;

//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 109。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
// 👍 209 👎 0


class 字典序的第K小数字 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthNumber(int n, int k) {
            //前缀
            long prefix = 1;
            //数字所在位置
            int pos = 1;
            while (pos < k) {
                int cnt = getCount(prefix, n);
                if (cnt + pos > k) {
                    //以prefix开头的数足够多，第k个数就在其中
                    //缩小范围 将prefix*10
                    prefix *= 10;
                    pos++;
                } else {
                    //以prefix开头的数不够多，第k个数在后面
                    //跳过以prefix开头的数
                    prefix++;
                    pos += cnt;
                }
            }
            return (int)prefix;
        }

        //计算以prefix为前缀，不小于n的数共有多少个
        private int getCount(long prefix, int n) {
            long cnt = 0;
            for (long a = prefix, b = prefix + 1; a <= n; a *= 10, b *= 10) {
                cnt += Math.min(n + 1, b) - a;
            }
            return (int)cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}