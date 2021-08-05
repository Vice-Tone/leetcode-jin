package editor.cn;

//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 556 👎 0

class 分发糖果 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        public int candy(int[] ratings) {
//            //需要同时满足左右两个规则
//            //分开计算左右规则
//            int[] left = new int[ratings.length];
//            int[] right = new int[ratings.length];
//            //满足左规则
//            for (int i = 0; i < ratings.length; i++) {
//                if (i > 0 && ratings[i] > ratings[i - 1]) {
//                    left[i] = left[i - 1] + 1;
//                } else {
//                    left[i] = 1;
//                }
//            }
//            //满足右规则
//            for (int i = ratings.length - 1; i >= 0; i--) {
//                if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
//                    right[i] = right[i + 1] + 1;
//                } else {
//                    right[i] = 1;
//                }
//            }
//            //同时满足左右规则，取较大值
//            int res = 0;
//            for (int i = 0; i < ratings.length; i++) {
//                res += Math.max(left[i], right[i]);
//            }
//            return res;
//        }

        //空间复杂度O(1)
        //记录递增序列和递减序列的长度
        public int candy(int[] ratings) {
            int n = ratings.length;
            int ret = 1;
            int inc = 1, dec = 0, pre = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i] >= ratings[i - 1]) {
                    dec = 0;
                    pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                    ret += pre;
                    inc = pre;
                } else {
                    dec++;
                    if (dec == inc) {
                        dec++;
                    }
                    ret += dec;
                    pre = 1;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}