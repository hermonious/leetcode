

// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点
public class _4reverseList {
    

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
