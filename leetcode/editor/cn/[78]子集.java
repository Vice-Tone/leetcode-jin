package editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1110 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 子集 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<Integer> track = new ArrayList<>();

            dfs(0, nums, track);
            return res;
        }

        private void dfs(int pos, int[] nums, ArrayList<Integer> track) {
            res.add(new LinkedList<>(track));
            for (int i = pos; i < nums.length; i++) {
                track.add(nums[i]);
                dfs(i + 1, nums, track);
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}