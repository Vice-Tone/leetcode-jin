package editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 219 👎 0

import java.util.PriorityQueue;

class 最小的k个数 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TopK问题 (分为TopK小、TopK大)有两种解法，下面以TopK小为例
        //1.小根堆
        //  构造一个小根堆，把元素全部offer进去，然后poll弹出K个元素即可
        //2.大根堆
        //  构造一个容量为K的大根堆，先offerK个元素，堆顶是当前最大的元素，
        //  只要后续元素比他小，就弹出堆顶元素，然后offer新元素，这样保证堆里的元素是较小的

        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            if (k == 0) {
                return res;
            }

            //PriorityQueue默认升序排列，是一个小根堆
            //下面这样写是降序排列，是个大根堆
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < k; i++) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; i++) {
                if (arr[i] < queue.peek()) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}