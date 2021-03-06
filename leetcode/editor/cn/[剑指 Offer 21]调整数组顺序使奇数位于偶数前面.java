package editor.cn;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 100 👎 0

class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            if (nums == null) {
                return null;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left != right) {
                while (nums[left] % 2 != 0 && left < right) {
                    ++left;
                }
                while (nums[right] % 2 == 0 && left < right) {
                    --right;
                }
                swap(nums, left++, right--);
            }
            return nums;
        }

        private void swap(int[] nums, int a, int b) {
            int tem = nums[a];
            nums[a] = nums[b];
            nums[b] = tem;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}