package editor.cn;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 765 👎 0

import java.util.ArrayList;

class 最大数 {
    public static void main(String[] args) {

        int[] ints = new int[]{10,2};
        String s = Solution.largestNumber(ints);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public static String largestNumber(int[] nums) {
            if (nums.length == 1) {
                return nums[0] + "";
            }
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i] + "");
            }
            //对数组排序，第一位大的排在前面，第一位相同往后顺延

            list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            StringBuilder sb = new StringBuilder();
            for (String num : list) {
                sb.append(num);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}