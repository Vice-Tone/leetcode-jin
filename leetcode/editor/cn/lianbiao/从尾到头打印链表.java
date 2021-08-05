package editor.cn.lianbiao;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 113 👎 0

import java.util.Stack;

class 从尾到头打印链表 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            int length = 0;
            while (head != null) {
                stack.push(head.val);
                head = head.next;
                length++;
            }
            int[] res = new int[length];
            int i = 0;
            while (!stack.isEmpty()) {
                res[i++] = stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}