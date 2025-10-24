    ArrayList，基于数组实现，初始容量为10，满之后扩容为1.5倍
    常用方法：
        boolean add(E e)  // 在末尾添加元素，返回是否成功
        void add(int index, E element)  // 在指定索引插入元素（后续元素右移）
        boolean addAll(Collection<? extends E> c)  // 批量添加另一个集合的元素

        E get(int index)
        int size()
        boolean isEmpty()

        E set(int index, E element)  // 替换指定索引的元素，返回被替换的旧元素

        E remove(int index)  // 删除指定索引的元素，返回被删除元素（后续元素左移）

        int indexOf(Object o)
        boolean contains(Object o)  // 判断列表是否包含指定元素

        Object[] toArray()
        <T> T[] toArray(T(T[] a)  // 转换为指定类型的数组
        List<E> subList(int fromIndex, int toIndex)

典型使用场景
    1.模拟动态数组
    2.模拟栈
    3.实现前缀和数组（prefix sum）
