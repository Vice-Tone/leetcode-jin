package editor.cn.hash;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1083 👎 0

class 缺失的第一个正数 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            //原地模拟hashMap
            int n = nums.length;
            //只关注[1,n]的数字，其他的全部处理成n+1
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            //遍历数组，将数组中nums[i]对应的下标-1的数组值修改为倒数，作为该数字出现过的标记
            //如果对应的下标-1的数组值已经为负数，则不用修改，用绝对值实现较为简洁
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            //打过标记后，若为负数，则表示该下标+1对应的数字出现过
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            //1到n全部出现过，则缺失的第一个正整数为n+1
            return n + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}