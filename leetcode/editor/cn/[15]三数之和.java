package editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3312 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            ArrayList<List<Integer>> res = new ArrayList<>();
            int n = nums.length;

            for (int first = 0; first < n; first++) {
                //跳过相同的数字
                if (first != 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int third = n - 1;
                for (int second = first + 1; second < n - 1; second++) {
                    //跳过相同的数字
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                        third--;
                    }
                    //second与third相遇时即可退出，后面的值只会增大
                    if (third == second) {
                        break;
                    }
                    if (nums[first] + nums[second] + nums[third] == 0) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[first]);
                        tmp.add(nums[second]);
                        tmp.add(nums[third]);
                        res.add(tmp);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}