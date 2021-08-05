package editor.cn.lianbiao;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 551 👎 0

class 旋转链表 {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            //求出链表长度
            int length = 1;
            ListNode index = head;
            while (index.next != null) {
                index = index.next;
                length++;
            }
            ListNode res = head;
            for (int i = 0; i < k % length; i++) {
                res = func(res);
            }
            return res;
        }

        //将链表最后一个节点移到表头，并返回表头
        private ListNode func(ListNode head) {
            ListNode p1 = head.next, p2 = head;
            while (p1.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2.next = null;
            p1.next = head;
            return p1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}