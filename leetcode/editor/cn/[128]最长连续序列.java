package editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 770 👎 0

import java.util.HashSet;

class 最长连续序列 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        public int longestConsecutive(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return 0;
//            }
//            HashSet<Integer> set = new HashSet<>();
//            for (int num : nums) {
//                set.add(num);
//            }
//            int longestLen = 0;
//            for (int num : nums) {
//                int cur = num;
//                int curLen = 1;
//                set.remove(num);
//                //从当前这个数向两边扩散
//                while (set.remove((cur - 1))) {
//                    cur--;
//                }
//                curLen += num - cur;
//                cur = num;
//                while (set.remove(cur + 1)) {
//                    cur++;
//                }
//                curLen += (cur - num);
//                longestLen = Math.max(curLen, longestLen);
//            }
//            return longestLen;
//        }

        //不需要向两边扩散，只需向n+1扩散，判断n-1是否在set中即可知道n是否计算过
        //但是在leetcode上时间很长，不如上一种解法
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : nums) {
                //如果set中有n-1，那么n一定已经被枚举过
                if (!set.contains(num-1)) {
                    int curNum = num;
                    int curLen = 1;
                    while (set.contains(curNum + 1)) {
                        curNum++;
                        curLen++;
                    }
                    res = Math.max(res, curLen);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}