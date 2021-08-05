package editor.cn.dfs;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 537 👎 0

import java.util.ArrayList;
import java.util.List;

class 组合 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = i + 1;
            }
            ArrayList<Integer> track = new ArrayList<>();

            dfs(0, nums, k, track);
            return res;
        }

        private void dfs(int pos, int[] nums, int k, ArrayList<Integer> track) {
            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = pos; i < nums.length; i++) {
                track.add(nums[i]);
                dfs(i + 1, nums, k, track);
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}