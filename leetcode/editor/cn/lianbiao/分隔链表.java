package editor.cn.lianbiao;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 392 👎 0

class 分隔链表 {
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
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            //虚拟出一个头结点
            ListNode res = new ListNode(0, head);

            //找到第一个大于等于x的节点
            ListNode pre = res, tail = head;
            while (tail != null) {
                if (tail.val >= x) {
                    break;
                }
                tail = tail.next;
                pre = pre.next;
            }

            //从第一个大于等于x的节点开始遍历
            ListNode p1 = tail;
            while (p1 != null && p1.next != null) {
                //节点的值小于x，把节点用尾插法接在pre之后
                if (p1.next.val < x) {
                    ListNode tmp = p1.next;
                    p1.next = p1.next.next;
                    //尾插
                    tmp.next = pre.next;
                    pre.next = tmp;
                    pre = pre.next;
                } else {
                    p1 = p1.next;
                }
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}