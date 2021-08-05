package editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 891 👎 0

class 回文链表 {
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
        //递归，空间复杂度O（n）
//        ListNode left;
//        public boolean isPalindrome(ListNode head) {
//            left=head;
//            return traverse(head);
//        }
//
//        private boolean traverse(ListNode right) {
//            if (right == null) {
//                return true;
//            }
//            boolean res = traverse(right.next);
//            res = res && left.val == right.val;
//            left= left.next;
//            return res;
//        }

        //空间复杂度O（1）
        ListNode slow, fast;

        public boolean isPalindrome(ListNode head) {
            slow = head;
            fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast != null)
                slow = slow.next;

            ListNode left = head;
            ListNode right = reverse(slow);
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head, nxt = head;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}