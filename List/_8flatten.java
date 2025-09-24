



// 在一个多级双向链表中，节点除了有两个指针分别指向前后两个节点，还有一个指针指向它的子链表，
// 并且子链表也是一个双向链表，它的节点也有指向子链表的指针。请将这样的多级双向链表展平成普通的双向链表，即所有节点都没有子链表
public class _8flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;

        while(node != null) {
            Node next = node.next;
            
            if(node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(node.child);

                node.child = null;
                node.next = child;
                child.prev = node;
                childTail.next = next;

                if(next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }


    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }
}
