package editor.cn;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1119 👎 0

class 排序链表 {
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
//        public ListNode sortList(ListNode head) {
//            return sortList(head, null);
//        }

        private ListNode sortList(ListNode head, ListNode tail) {
            //递归返回
            if (head == null) {
                return null;
            }
            if(head.next == tail){
                head.next = null;
                return head;
            }
            //找到链表中间节点
            ListNode slow = head, fast = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow;
            //递归排序
            ListNode head1 = sortList(head, mid);
            ListNode head2 = sortList(mid, tail);
            //合并
            return merge(head1, head2);

        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = l1 == null ? l2 : l1;
            return dummyHead.next;
        }

        //第二种方法，不需要尾结点
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //寻找中点，如果是偶数个节点，选择偏左的节点
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode head1 = sortList(head);
            ListNode head2 = sortList(tmp);
            return merge(head1, head2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}