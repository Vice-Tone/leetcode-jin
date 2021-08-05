package editor.cn.heap;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 堆 哈希表 
// 👍 767 👎 0


import java.util.HashMap;
import java.util.PriorityQueue;

class 前K个高频元素 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //小根堆
        public int[] topKFrequent(int[] nums, int k) {
            if (nums == null || k == 0) {
                return null;
            }
            int[] res = new int[k];
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for (int num : nums) {
                hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> hashmap.get(o1) - hashmap.get(o2));
//            heap.addAll(hashmap.entrySet());
            for (int key : hashmap.keySet()) {
                heap.offer(key);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            for (int i = 0; i < k; i++) {
                res[i] = heap.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}