

// 给定一个链表，链表中节点的顺序是 L0→ L1→ L2→…→ Ln-1→ Ln，
// 请问如何重排链表使节点的顺序变成 L0→ Ln→ L1→ Ln-1→ L2→ Ln-2→…？
public class _6reorderList {


    // 反转链表
    private ListNode reverseList(ListNode head) {
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


    // 交替合并链表
    private void link(ListNode node1, ListNode node2, ListNode head) {
        // pre 指向当前合并链表的末尾，初始为哑节点
        ListNode pre = head;

       while(node1 != null && node2 != null) {
            // 保存 node1 的下一个节点（关键：避免后续操作丢失前半段的剩余节点）
            ListNode temp = node1.next;
            
            // 将 node1 的当前节点接到 pre 后面
            pre.next = node1;
            // node2 的当前节点接到 node1 后面（实现“前半段节点→后半段节点”的交替）
            node1.next = node2;

            // pre 移到 node2（现在 node2 是合并后的末尾）
            pre = node2;
            // node1 移到之前保存的下一个节点
            node1 = temp;
            // node2 移到自身的下一个节点
            node2 = node2.next;
       }
       if(node1 != null) {
           pre.next = node1;
       }
    }



    // 把原链表分为前后两半，将后半段链表反转，然后从各自头节点开始，交替合并两段链表
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next;
            }
        }

        ListNode temp = slow.next;
        slow.next = null;
        link(head, reverseList(temp), dummy);
    }
}


