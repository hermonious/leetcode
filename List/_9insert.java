
// 在一个循环链表中节点的值 ‘递增排序’，请设计一个算法在该循环链表中插入节点，
// 并保证插入节点之后的循环链表仍然是排序的
public class _9insert {

    class Node {
        int val;
        Node next;
        Node(int val) { 
            this.val = val; 
        }
    }
    
    public Node insert(Node head, int insertVal) {

        Node node = new Node(insertVal);
        if (head ==null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }


    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;

        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;

            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
