


哨兵节点是为了简化处理链表边界条件而引入的附加链表节点，通常位于链表头部，它的值没有任何意义。
在一个有哨兵节点的链表中，从第二个节点开始才真正保存有意义的信息

哑节点的核心作用是：‘消除特殊性’，只要操作中涉及以下场景，都可以考虑使用哑节点：
    
    1、需要处理 “头节点可能被修改 / 删除” 的情况；
    2、需要统一 “空链表” 和 “非空链表” 的逻辑；
    3、需要为某个节点（尤其是头节点）寻找一个 “固定的前驱”；
    4、需要拆分或合并链表（作为子链表的虚拟头）。


1、简化链表的 ‘尾插法’ 操作。
首先创建一个哨兵节点 dummy，并把该节点当作链表的头节点，然后把原始的链表添加在哨兵节点的后面
    
        public ListNode append(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode newNode = new ListNode(val);
            ListNode cur = dummy;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            return dummy.next;
        }

2、简化链表的 ‘删除节点’ 操作
    
        public ListNode delete(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode cur = dummy;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
            return dummy.next;
        }


3、合并两个 ’有序‘ 链表
4、链表的 ‘部分反转‘ 操作
5、链表分区
6、奇偶链表

