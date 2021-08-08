package editor.cn.lianbiao;

/**
 * @author ：jin
 * @description:
 * @date ：Created in 2021/8/8 5:02 下午
 */
public class 美团二面反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node5 = new ListNode(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = reverseInner(node1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class ListNode {
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

    //k个一组反转链表，组外反转，组内不变
    //例子：1->2->3->4->5
    //变为：5->3->4->1->2

    private static int length = 0;

    public static ListNode reverseInner(ListNode head, int k) {
        ListNode newHead = reverse(head, null);
        int num = length % k;

        ListNode dummyhead = new ListNode(-1, newHead);
        ListNode pre = dummyhead;
        for (int i = 0; i < num; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode succ = reverseKGroup(cur, k);
        pre.next = succ;
        return newHead;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = head;
        b = head;
        for (int i = 0; i < k; i++) {
            //链表个数不足k个
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        //a到b为左闭右开
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转a到b之间的链表，a到b为左闭右开
     *
     * @param a
     * @param b
     * @return 返回反转后的头节点
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            length++;
        }
        return pre;
    }
}
