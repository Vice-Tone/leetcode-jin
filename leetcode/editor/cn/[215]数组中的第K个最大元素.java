package editor.cn;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1089 👎 0

class 数组中的第K个最大元素 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
//            return quickSort(nums, k);
//            return TopKHeap(nums, k);
            return quickSelect(nums, 0, nums.length - 1, k);
        }

        //使用小根堆
//        private int TopKHeap(int[] nums, int k) {
//            PriorityQueue<Integer> heap = new PriorityQueue<>(k);
//            for (int i = 0; i < k; i++) {
//                heap.offer(nums[i]);
//            }
//            for (int i = k; i < nums.length; i++) {
//                if (nums[i] <= heap.peek()) {
//                    continue;
//                } else {
//                    heap.poll();
//                    heap.offer(nums[i]);
//                }
//            }
//            return heap.peek();
//        }

//        //快速排序
//        private int quickSort(int[] nums, int k) {
//            Arrays.sort(nums);
//            return nums[nums.length - k];
//        }

        private int quickSelect(int[] nums, int low, int high, int k) {
            // 转换一下，第 k 大元素的索引是 len - k
            int target = nums.length - k;
            while (true) {
                int index = partition(nums, low, high);
                if (index == target) {
                    return nums[index];
                } else if (index < target) {
                    low = index + 1;
                } else {
                    high = index - 1;
                }
            }
        }

        private int partition(int[] a, int low, int high) {
            int i, j, index;
            i = low;
            j = high;
            index = a[i];
            while (i < j) {
                while (i < j && a[j] >= index) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < index) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = index;
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}