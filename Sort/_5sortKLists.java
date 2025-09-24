import java.util.PriorityQueue;





// 合并k个升序链表




public class _5sortKLists {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { 
            this.val = val; 
        }
    }
    
    // 1.利用最小堆选择值最小的节点
    // 用 k 个指针分别指向这 k 个链表的头节点，每次从这 k 个节点中选取值最小的节点。
    // 然后将指向值最小的节点的指针向后移动一步，再比较 k 个指针指向的节点并选取值最小的节点。
    // 重复这个过程，直到所有节点都被选取出来。
    // 将 k 个节点放入一个最小堆中，位于堆顶的节点就是值最小的节点。每当选取某个值最小的节点之后，将它从堆中删除并将它的下一个节点添加到堆中。

    // O(nlongk) + O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode least = minHeap.poll();
            cur.next = least;
            cur = cur.next;
            if (least.next != null) {
                minHeap.offer(least.next);
            }
        }

        return dummy.next;
    }









    // 2.归并排序
    // O(nlogk) + O(logk)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length);
    }

    public ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start + 1 == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode head1 = mergeList(lists, start, mid);
        ListNode head2 = mergeList(lists, mid, end);
        return merge(head1, head2);
    }

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
