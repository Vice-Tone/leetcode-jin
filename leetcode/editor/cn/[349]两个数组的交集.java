package editor.cn;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 410 👎 0

import java.util.HashSet;

class 两个数组的交集 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }
            for (int i : nums2) {
                set2.add(i);
            }
            HashSet<Integer> resSet = new HashSet<>();
            for (Integer num : set1) {
                if (set2.contains(num)) {
                    resSet.add(num);
                }
            }
            int[] res = new int[resSet.size()];
            int index = 0;
            for (Integer num : resSet) {
                res[index++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}