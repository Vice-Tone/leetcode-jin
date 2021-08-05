package editor.cn;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 392 👎 0

import java.util.Deque;
import java.util.LinkedList;

class 两数相加II {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            Deque<Integer> stack1 = new LinkedList<>();
            Deque<Integer> stack2 = new LinkedList<>();
            //计算l1的长度
            int length1 = 0;
            ListNode p = l1;
            while (p != null) {
                length1++;
                p = p.next;
            }
            //计算l2的长度
            int length2 = 0;
            p = l2;
            while (p != null) {
                length2++;
                p = p.next;
            }
            //添加0
            if (length1 < length2) {
                int diff = length2 - length1;
                while (diff > 0) {
                    stack1.push(0);
                    diff--;
                }
            }
            if (length1 > length2) {
                int diff = length1 - length2;
                while (diff > 0) {
                    stack2.push(0);
                    diff--;
                }
            }

            p = l1;
            while (p != null) {
                stack1.push(p.val);
                p = p.next;
            }
            p = l2;
            while (p != null) {
                stack2.push(p.val);
                p = p.next;
            }
            ListNode res = new ListNode();
            int jinwei = 0;
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int val = stack1.pop() + stack2.pop() + jinwei;
                int nodeVal = val % 10;
                jinwei = val / 10;
                ListNode node = new ListNode(nodeVal);
                //采用头插法
                node.next = res.next;
                res.next = node;
            }
            if (jinwei != 0) {
                ListNode node = new ListNode(jinwei);
                node.next = res.next;
                res.next = node;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}