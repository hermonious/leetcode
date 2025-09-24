

// 如何判断一个链表是不是回文？要求解法的时间复杂度是 O(n)，并且不得使用超过 O(1)的辅助空间
public class _7isPalindrome {
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

    // 比较两个链表是否相等
    private boolean equals(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == null && head2 == null;
    }
    

    // 思路和_6reorderList.java 类似，先找到链表的中点，然后将后半段链表反转，最后从链表头和中点开始，依次比较节点值是否相等
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        if(fast.next != null) {
            secondHalf = slow.next.next;
        }

        slow.next = null;
        return equals(secondHalf, reverseList(head));
    }
}
