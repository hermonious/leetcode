    ArrayList，基于数组实现，初始容量为10，满之后扩容为1.5倍
    
    
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
