package editor.cn;

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 121 👎 0

import java.util.PriorityQueue;

class 数据流中的中位数 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private PriorityQueue<Integer> q1;
        private PriorityQueue<Integer> q2;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //小根堆
            q1 = new PriorityQueue<>();
            //大根堆
            q2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            if (q1.size() != q2.size()) {
                q1.offer(num);
                q2.offer(q1.poll());
            } else {
                q2.offer(num);
                q1.offer(q2.poll());
            }
        }

        public double findMedian() {
            return q1.size() == q2.size() ? (q1.peek() + q2.peek()) / 2.0 : q1.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}