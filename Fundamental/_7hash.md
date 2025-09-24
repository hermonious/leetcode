



HashMap，又称散列表，它通过建立键 key 与值 value 之间的映射，实现高效的元素查询。具体而言，我们向哈希表中输入一个键 key ，则可以在 O(1) 时间内获取对应的值 value
# 哈希表的添加、查询、删除都是 O(1)
基本性质：
1. 数组 + 链表 / 红黑树
2. 允许 1 个null或者多个null
3. 无序
4. 非线程安全
5. 默认初始容量 = 16，默认负载因子 = 0.75， 扩容时容量翻倍
6. Java8开始，链表长度 > 8 && 容量 >= 64时转成红黑树，查找效率降为 O(logn)

常用方法
    put(key, value)         // 插入键值对，如果key存在，替换旧的value并返回
    putAll(Map<> m)         // 复制另外一个Map的所有映射
    putIfAbsent(key, value) // key不存在或者映射为 null 时才插入，返回当前映射的值

    get(key)              // 根据key获取value，key不存在或者映射为null时，返回null
    getOrDefault(key, defaultValue)  // 获取值，不存在就返回默认值

    remove(key)             // 删除key，返回被删除的value
    remove(key, value)      // 只有当key映射到对应的value才删除，成功返回true

    containsKey(key)        
    containsValue(value)
    isEmpty()
    size()

#   遍历使用
#   Set<K> keySet()                         // key的集合视图
#   Collection<V> values()                  // value的集合视图
#   Set<Map.Entry<K, V>> entrySet()         // 键值对（Entry）的集合视图，最常用

    replace(key, value)
    replace(key, oldValue, newValue)

    clone()
    equals()
    hashCode()
    toString()











# 自定义对象必须重写 equals() 和 hashCode()。否则无法正确判断重复，可能导致重复元素存入
HashSet 是基于 HashMap 实现的集合（Set） 数据结构，用于存储不重复的元素
基本性质：
1. 基于HashMap，元素作为 HashMap 的 key 存储，value 使用一个静态常量 PRESENT
# 2. 去重（通过 equals() 和 hashCode() 判断）
3. 无序
4. 允许 1 个null
5. 非线程安全
6. 默认初始容量 16，负载因子 0.75


常用方法：
    add(E e)
    remove(Object o)
    contains(Object o)
    isEmpty()
    size()
    iterator()
    toArray()

    addAll()
    removeAll()
    retainAll()
    containsAll()

    clone()

    equals()
    hashCode()
    toString()




