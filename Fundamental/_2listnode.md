/* 
 *  初始化、（插入、删除、查找、访问）、
 */
public class listnode {
    

    // 单链表节点
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // 双链表节点
    class ListNode {
        int val;
        ListNode next;
        ListNode prev; 
        ListNode(int val) {
            this.val = val;
        }
    }



    // 1. 初始化（构建链表）
    
    // 1 -> 9 -> 3
    ListNode node0 = new ListNode(1);
    ListNode node1 = new ListNode(9);
    ListNode node2 = new ListNode(3);

    // 节点的引用关系
    node0.next = node1;
    node1.next = node2;





    // 2. 插入、删除、查找、访问

    // node之后插入节点p
    public void insert(ListNode node, ListNode p) {
        ListNode next = node.next;
        p.next = next;
        node.next = p;
    }


    // 删除node后面第 1 个节点p
    public void remove(ListNode node) {
        if (node.next == null) {
            return;
        }

        ListNode p = node.next;
        ListNode k = p.next;
        node.next = k;
    }



    // 访问索引为 index 的节点
    public ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }


    // 查找
    public int find(ListNode head, int target) {
        int cur = head;
        int index = 0;

        while (cur != null) {
            if (cur.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }
}
