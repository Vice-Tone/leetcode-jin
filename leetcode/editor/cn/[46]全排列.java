package editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1254 👎 0

import java.util.LinkedList;
import java.util.List;

class 全排列 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return res;
            }
            LinkedList<Integer> track = new LinkedList<>();
            dfs(nums, track);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> track) {

            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int num : nums) {
                if (track.contains(num)) {
                    continue;
                }
                track.add(num);

                dfs(nums, track);

                track.removeLast();

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}