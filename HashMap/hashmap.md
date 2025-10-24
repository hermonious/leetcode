
HashMap 实现原理
      
      底层结构：JDK 8 起采用 数组 + 链表 + 红黑树 混合结构；数组每个桶（bucket）存储键值对，哈希冲突时先用链表，链表长度 ≥ 8 且数组长度 ≥ 64 时转为红黑树。
      哈希机制：通过 key.hashCode() 计算哈希值，再经扰动函数（高位参与运算）减少冲突，最终通过位运算确定桶索引。
      动态扩容：初始容量为 16（无参构造），负载因子默认为 0.75；当元素数量超过 容量 × 负载因子 时触发扩容。
      扩容机制：容量扩展为原来的 2 倍，并重新分配所有键值对；JDK 8 优化了迁移过程，利用链表/树的低位高位特性，避免重新计算哈希。
      核心操作高效：在理想哈希分布下，get/put/remove 平均时间复杂度为 O(1)；最坏情况（大量冲突）为 O(log n)（红黑树）或 O(n)（长链表）。
      线程不安全：多线程并发操作可能导致数据丢失、死循环（JDK 7 中 resize 易死循环，JDK 8 改进但仍不安全）。
      
      内存优化：
      不提供类似 trimToSize() 的方法，但可通过构造时指定初始容量和负载因子减少扩容。
      空 HashMap 不分配底层数组，首次插入时才初始化。
      
      序列化优化：底层数组标记为 transient，自定义序列化逻辑仅写入有效键值对，避免序列化空桶。
      适用场景：需要 快速键值映射、频繁查找/插入/删除 的场景；不适合要求有序或线程安全的场合。
      
      与 Hashtable / ConcurrentHashMap 对比：
      Hashtable 线程安全但性能差（全表锁）；
      ConcurrentHashMap 支持高并发（分段锁/CAS + synchronized），是多线程首选。



所有方法

      // 用来遍历Map的，非常重要
    Set<Map.Entry<K,V>> entrySet()
    Set<K> keySet()
    Collection<V> values()


    V put(K key, V value)
    V remove(Object key)
    V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
        map.computeIfAbsent(key, k -> new Value(f(k)));
        map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
        
    V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
        map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg));
        
    V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
    V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
        map.merge(key, msg, String::concat)


    int size()


    boolean isEmpty()
    boolean containsKey(Object key)
    boolean containsValue(Object value)


    void clear()
    void putAll(Map<? extends K,? extends V> m)


    Object clone()
    
    








