package editor.cn.lianbiao;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 705 👎 0

class 反转链表2 {
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

        //解法一，递归比较难以理解
//        private ListNode successor = null;
//
//        public ListNode reverseBetween(ListNode head, int left, int right) {
//            if (left == 1) {
//                return reverseN(head, right);
//            }
//            head.next = reverseBetween(head.next, left - 1, right - 1);
//            return head;
//        }
//
//        public ListNode reverseN(ListNode head, int n) {
//            if (n == 1) {
//                successor = head.next;
//                return head;
//            }
//            ListNode last = reverseN(head.next, n - 1);
//            head.next.next = head;
//            head.next = successor;
//            return last;
//        }


        //解法二需要多次遍历
//        public ListNode reverseBetween(ListNode head, int left, int right) {
//            ListNode dummyHead = new ListNode(-1, head);
//            ListNode pre = dummyHead;
//            for (int i = 0; i < left - 1; i++) {
//                pre = pre.next;
//            }
//            ListNode leftNode = pre.next;
//            ListNode rightNode = pre;
//            for (int i = 0; i < right - left + 1; i++) {
//                rightNode = rightNode.next;
//            }
//            ListNode succ = rightNode.next;
//            //断开链表
//            pre.next = null;
//            rightNode.next = null;
//            //反转部分链表
//            ListNode newHead = reverse(leftNode);
//            //重新连接上
//            pre.next = rightNode;
//            leftNode.next = succ;
//            return dummyHead.next;
//        }
//
//        private ListNode reverse(ListNode head) {
//            ListNode pre = null, cur = head, nxt = head;
//            while (cur != null) {
//                nxt = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = nxt;
//            }
//            return pre;
//        }

        //解法三，一次遍历
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummyHead = new ListNode(-1, head);
            ListNode pre = dummyHead;
            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }
            ListNode cur = pre.next, nxt = null;
            for (int i = 0; i < right - left; i++) {
                nxt = cur.next;
                cur.next = nxt.next;
                //这里要注意不是nxt.next = cur; nxt要链接到反转后的第一个节点，即pre的next
                nxt.next = pre.next;
                pre.next = nxt;
            }
            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}