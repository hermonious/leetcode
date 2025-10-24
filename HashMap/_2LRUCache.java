

// 请设计实现一个最近最少使用（Least Recently Used，LRU）缓存，要求如下两个操作的时间复杂度都是 O(1)。 
// get(key)：如果缓存中存在键 key，则返回它对应的值；否则返回-1。 
// put(key, value)：如果缓存中之前包含键 key，则它的值设为 value；否则添加键 key 及对应的值 value。在添加一个键时，如果缓存容量已经满了，则在添加新键之前删除最近最少使用的键（缓存中最长时间没有被使用过的元素）。 

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class ListNode {
        int key, value;
        ListNode prev, next;
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, ListNode> map;
    private final ListNode head;
    private final ListNode tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value; // 更新值
            moveToTail(node);
        } else {
            if (map.size() == capacity) {
                ListNode lru = head.next;
                deleteNode(lru);
                map.remove(lru.key);
            }
            ListNode newNode = new ListNode(key, value);
            insertToTail(newNode);
            map.put(key, newNode);
        }
    }

    private void moveToTail(ListNode node) {
        deleteNode(node);
        insertToTail(node);
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}
