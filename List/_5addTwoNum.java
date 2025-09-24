

// 给定两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把它们的和仍然用单向链表表示？
// 链表中的每个节点表示整数十进制的一位，并且头节点对应整数的最高位数而尾节点对应整数的个位数
public class _5addTwoNum {
    
    // 先反转。方便从最低位开始计算
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

    // 从低位到高位相加，低位对齐，满 10 进 1
    private ListNode addReverse(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;

        while(head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val) 
            + (head2 == null ? 0 : head2.val) + carry;

            carry = sum >= 10 ? 1 : 0;//进位
            int current = sum >= 10 ? sum - 10 : sum;//当前位
            ListNode newNode = new ListNode(current);

            // 将新创建的节点 newNode 链接到结果链表的末尾
            sumNode.next = newNode;
            // 移动到下一个节点
            sumNode = sumNode.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if(carry > 0) {
            sumNode.next = new ListNode(carry);
        }
        return dummy.next;
    }


    // 再次反转，才是正确的输出
    public ListNode addTwoNum(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        ListNode reverseHead = addReverse(head1, head2);
        return reverseList(reverseHead);
    }

}
