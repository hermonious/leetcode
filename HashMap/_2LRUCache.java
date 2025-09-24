import java.util.HashMap;

// 请设计实现一个最近最少使用（Least Recently Used，LRU）缓存，要求如下两个操作的时间复杂度都是 O(1)。 
// get(key)：如果缓存中存在键 key，则返回它对应的值；否则返回-1。 
// put(key, value)：如果缓存中之前包含键 key，则它的值设为 value；否则添加键 key 及对应的值 value。在添加一个键时，如果缓存容量已经满了，则在添加新键之前删除最近最少使用的键（缓存中最长时间没有被使用过的元素）。 


public class _2LRUCache {
    
    // 双向链表节点类，用于存储缓存数据
    class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // LRU缓存实现类
    class LRUCache {
        private ListNode head;       // 头哨兵节点
        private ListNode tail;       // 尾哨兵节点
        private int capacity;        // 缓存容量
        private HashMap<Integer, ListNode> map;  // 哈希表，用于O(1)查找节点

        // 构造方法，初始化缓存
        public LRUCache(int capacity) {
            map = new HashMap<>();
            // 初始化哨兵节点
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }
        
        // 获取缓存中的值
        public int get(int key) {
            ListNode node = map.get(key);
            if (node == null) {
                return -1;  // 键不存在，返回-1
            }
            // 将访问的节点移到尾部，表示最近使用
            moveToTail(node, node.value);
            return node.value;
        }
        
        // 向缓存中放入键值对
        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 键已存在，更新值并移到尾部
                moveToTail(map.get(key), value);
            } else {
                // 键不存在，需要插入新节点
                // 缓存已满，删除最久未使用的节点（头部节点）
                if (map.size() == capacity) {
                    ListNode leastUsedNode = head.next;
                    deleteNode(leastUsedNode);
                    map.remove(leastUsedNode.key);
                }
                // 插入新节点到尾部
                ListNode newNode = new ListNode(key, value);
                insertToTail(newNode);
                map.put(key, newNode);
            }
        }
        
        // 将节点移动到尾部（先删除再插入）
        private void moveToTail(ListNode node, int newValue) {
            deleteNode(node);
            node.value = newValue;  // 更新节点值
            insertToTail(node);
        }
        
        // 从链表中删除节点
        private void deleteNode(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        // 将节点插入到链表尾部
        private void insertToTail(ListNode node) {
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }
    }
}
