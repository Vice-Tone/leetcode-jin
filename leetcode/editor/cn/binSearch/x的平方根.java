package editor.cn.binSearch;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 688 👎 0

class x的平方根 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //将根号转换为1/2次方来进行计算
//        public int mySqrt(int x) {
//            if (x == 0) {
//                return 0;
//            }
//            int res = (int) Math.exp(0.5 * Math.log(x));
//            return (res + 1) * (res + 1) <= x ? res + 1 : res;
//        }

        //k*k<=x的最大k值为x的平方根的整数部分
        //二分查找
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            int left = 0, right = x;
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid * mid <= x) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}