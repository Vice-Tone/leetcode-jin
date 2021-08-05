package editor.cn;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 945 👎 0

import java.util.HashMap;

class 和为K的子数组 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //前缀和数组
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            //计算前缀和
            int res = 0;
            int pre = 0;
            for (int i = 0; i < nums.length; i++) {
                //计算当前位置的前缀和
                pre += nums[i];
                int sum_j = pre - k;
                //如果map中存在sum_j，就说明存在pre-sum_j == k 的子数组，即nums[i...j]和为k
                if (map.containsKey(sum_j)) {
                    res += map.get(sum_j);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}