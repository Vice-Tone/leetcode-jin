package editor.cn;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 
// 👍 232 👎 0

class 数组中数字出现的次数II {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bits = new int[32];
            for (int i = 0; i < nums.length; i++) {
                int j = 0;
                while (nums[i] != 0) {
                    bits[j] += nums[i] % 2;
                    nums[i] /= 2;
                    j++;
                }
            }
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res += (bits[i] % 3) * (1 << i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}