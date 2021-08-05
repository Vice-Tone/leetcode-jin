package editor.cn;

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000
// 
// Related Topics 数组 数学 
// 👍 262 👎 0

import java.util.Arrays;

class 三个数的最大乘积 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int maximumProduct(int[] nums) {
//            if (nums.length == 3) {
//                return nums[0] * nums[1] * nums[2];
//            }
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i+1; j < nums.length; j++) {
//                    for (int k = j+1; k < nums.length; k++) {
//                        if(max<nums[i] * nums[j] * nums[k]){
//                            max = nums[i] * nums[j] * nums[k];
//                        }
//                    }
//                }
//            }
//            return max;
//        }
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}