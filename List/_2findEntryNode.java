

// 如果一个链表中包含环，找出环的入口节点



public class _2findEntryNode {

    // 辅助方法，判断链表是否有环，若有则返回环内的一个节点
    private ListNode getNodeInLoop(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        // 初始化快慢指针：慢指针从第一个节点出发，快指针从第二个节点出发
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        // 循环条件：快慢指针均未走到链表末尾
        while(slow != null && fast != null) {
            if(slow == fast) {
                return slow;
            }

            slow = slow.next;
            fast = fast.next;
            // 快指针的两步移动被拆分为两次单步移动，且第二次移动前会判断 fast != null
            if(fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }




    // 主方法，负责协调找到环的入口节点
    public ListNode detectCycle1(ListNode head) {
        // 第一步：获取环内任意节点（若为null，说明无环）
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null) {
            return null;
        }
        // 第二步：计算环的长度（环内节点总数）
        int loopCount = 1;
        for(ListNode n = inLoop; n.next != inLoop; n = n.next) {
            loopCount++;
        }

        ListNode fast = head;
        // 快指针先移动环长的步数
        for(int  i = 0; i < loopCount; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        // 慢指针从 head 出发，与快指针同步移动，相遇点即为入口节点
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }




    // 简化写法，根本不需要求出环中节点的数目
    // 从链表头节点到环入口的距离，等于从快慢指针相遇点（环内节点）绕环一周回到入口的距离
    public ListNode detectCycle2(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null) {
            return null;
        }

        ListNode cur = head;
        while(cur != inLoop) {
            cur = cur.next;
            inLoop = inLoop.next;
        }
        return cur;
    }
}
