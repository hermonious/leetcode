
// 如果给定一个链表，请问如何删除链表中的倒数第 k 个节点


// 使用快慢双指针，fast先走k步，然后fast和slow一起走，当fast走到头时，slow就是倒数第k个节点
public class _1removeKthFromEnd {
    public ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = head;
        ListNode slow = dummy;

        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 通过 前驱.next = 前驱.next.next 完成删除
        // 哑节点的作用是充当头节点的 “虚拟前驱”，让所有节点（包括头节点）都有一个可操作的前驱
        slow.next = slow.next.next;
        return dummy.next;
    }
}