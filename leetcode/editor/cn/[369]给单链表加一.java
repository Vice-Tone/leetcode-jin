package editor.cn;

//用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。 
//
// 你可以假设这个整数除了 0 本身，没有任何前导的 0。 
//
// 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
// 
// Related Topics 递归 链表 
// 👍 67 👎 0

import java.util.ArrayList;

class 给单链表加一 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode plusOne(ListNode head) {
            if (head == null) {
                return null;
            }
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode res = null;
            ListNode cur = head;
            while (cur != null) {
                list.add(cur);
                cur = cur.next;
            }
            int index = list.size()-1;
            //从最后一个节点开始判断
            while (index >= 0 && list.get(index).val == 9) {
                list.get(index).val = 0;
                index--;
            }
            if (index < 0) {
                //第一个节点为9,要添加一个新节点
                res = new ListNode(0, head);
            } else {
                list.get(index).val++;
            }
            return index<0 ? res : head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}