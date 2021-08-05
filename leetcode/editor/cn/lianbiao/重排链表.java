package editor.cn.lianbiao;

//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 576 👎 0

import java.util.ArrayList;

class 重排链表 {
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
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
//            链表方法
//            ListNode left, leftNext, tail, preTail;
//            left = head;
//            leftNext = left.next;
//            preTail = head;
//            tail = head.next;
//            while (tail.next != null) {
//                preTail = preTail.next;
//                tail = tail.next;
//            }
//            while (left != tail) {
//                //修改指针
//                left.next = tail;
//                tail.next = leftNext;
//                left = leftNext;
//                leftNext = leftNext.next;
//                tail = preTail;
//                指针不好往前移
//            }
            ArrayList<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while (cur.next != null) {
                list.add(cur);
                cur = cur.next;
            }
            //使用list记住节点的位置
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) {
                    break;
                }
                list.get(j).next = list.get(i);
                j--;
            }
            list.get(i).next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}