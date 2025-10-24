ArrayList 实现原理

    底层结构：基于 Object[] 数组实现，元素连续存储，支持随机访问。
    动态扩容：初始容量为 0（无参构造），首次添加时扩至 10；后续扩容为原容量的 1.5 倍。
    扩容机制：通过 Arrays.copyOf() 创建新数组并复制元素，均摊插入时间复杂度为 O(1)。
    随机访问高效：get/set 操作时间复杂度为 O(1)。
    中间插入/删除低效：需移动元素，时间复杂度为 O(n)；尾部插入为 O(1) 均摊。
    线程不安全：多线程并发修改可能导致数据不一致或异常。
    
    内存优化：
        trimToSize()：释放多余容量。
        ensureCapacity()：预分配空间避免频繁扩容。
    
    序列化优化：使用 transient 修饰底层数组，自定义序列化逻辑只保存有效元素。
    适用场景：频繁随机访问、尾部增删；不适用频繁中间插入/删除。
    与 LinkedList 对比：ArrayList 内存更紧凑、缓存更友好，绝大多数场景性能更优。
    
    
    所有方法：
        int size()
        int hashCode()
        int indexOf(Object o)
        int lastIndexOf(Object o)


        Iterator<E> iterator()
        ListIterator<E> listIterator()
        ListIterator<E> listIterator(int index)
        Spliterator<E> spliterator()
        List<E> subList(int fromIndex, int toIndex)



        void clear()
        void trimToSize()
        void add(int index, E element)  // 指定索引插入
        void ensureCapacity(int minCapacity)
        void forEach(Consumer<? super E> action)
        protected void removeRange(int fromIndex, int toIndex)


        boolean add(E e)  // 末尾添加
        boolean isEmpty()
        boolean remove(Object o)
        boolean equals(Object o)
        boolean contains(Object o) 
        boolean retainAll(Collection<?> c)
        boolean addAll(Collection<? extends E> c)  // 批量插入另一个集合的元素
        boolean addAll(int index, Collection<? extends E> c)
        boolean removeAll(Collection<?> c)
        boolean removeIf(Predicate<? super E> filter)
        

        E get(int index)
        E set(int index, E element)
        E remove(int index)

        
        Object[] toArray()
        <T> T[] toArray(T[] a)
        Object clone()
        
       
    

典型使用场景
    1.模拟动态数组
    2.模拟栈
    3.实现前缀和数组（prefix sum）
