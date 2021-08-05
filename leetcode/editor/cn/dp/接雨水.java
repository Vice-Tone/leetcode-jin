package editor.cn.dp;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2330 👎 0

class 接雨水 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n == 0) {
                return 0;
            }
            //leftMax[i]表示下标i左边最大的height
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            //res[i]表示下标i处可以接下res[i]的雨水
            int[] res = new int[n];

            leftMax[0] = height[0];
            rightMax[n - 1] = height[n - 1];

            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            for (int i = 0; i < n; i++) {
                res[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            int sum = 0;
            for (int i : res) {
                sum += i;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}