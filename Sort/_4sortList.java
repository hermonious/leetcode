


// 输入一个链表的头节点，请将该链表排序
// 使用递归，实现链表的归并排序



public class _4sortList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { 
            this.val = val; 
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = spilt(head);

        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }




    // split 将链表分成两半并返回后半部分链表的头节点。再将链表分成两半后分别递归地将它们排序
    private ListNode spilt(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        return second;
    }






    // 与合并数组不同的是，不需要另外一个链表来保存合并之后的节点，而只需要调整指针的指向
    private ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        cur.next = head1 != null ? head1 : head2;
        return dummy.next;
    }
}
