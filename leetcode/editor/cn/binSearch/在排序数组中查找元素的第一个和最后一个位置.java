package editor.cn.binSearch;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1175 👎 0

class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
//        System.out.println((5 - 3) >>> 1);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int firstIndex = binarySearchV1(nums, target);
            int secondIndex = binarySearchV2(nums, target);
            if (firstIndex < 0 || secondIndex > nums.length -1
                    || nums[firstIndex] != target || nums[secondIndex] != target) {
                return new int[]{-1, -1};
            }
            return new int[]{firstIndex, secondIndex};
        }

        // 二分查找第一个大于等于target的元素
        private int binarySearchV1(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int res = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target < nums[mid]) {
                    high = mid - 1;
                } else if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    res = mid;
                    high = mid - 1;
                }
            }
            return res;
        }

        // 二分查找第一个大于target的元素
        private int binarySearchV2(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int res = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (target < nums[mid]) {
                    high = mid - 1;
                } else if (target > nums[mid]) {
                    low = mid + 1;
                } else {
                    res = mid;
                    low = mid + 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}