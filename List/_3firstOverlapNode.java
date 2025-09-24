


// 输入两个单向链表，找出它们的第 1 个重合节点





public class _3firstOverlapNode {
    private int countList(ListNode head) {
        int cnt = 0;
        while(head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    // 把这个问题转化成：求有环链表的入口节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = countList(headA);
        int cnt2 = countList(headB);
        int delta = Math.abs(cnt1 - cnt2);

        ListNode l = cnt1 > cnt2 ? headA : headB;
        ListNode s = cnt1 > cnt2 ? headB : headA;

        for(int i = 0; i < delta; i++) {
            l = l.next;
        }
        while(l != s) {
            l= l.next;
            s = s.next;
        }
        return l;
    }
}