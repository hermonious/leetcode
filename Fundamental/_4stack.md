stack的常用方法
# 继承Vector的      (不推荐使用，破坏了栈的 ‘后进先出’ 原则)
    add(int index, E element)
    get(int index)
    remove(Object o)
    size()

# 自带的    (也不推荐使用)
    empty()
    peek()
    pop()
    push()
    search()

Vector线程安全但是慢，Deque虽然线程不安全但是快。
单线程时，ArrayDeque性能最好。需要线程安全，使用ConcurrentLinkedDeque
## 推荐使用 Deque(比如 ArrayDeque、 LinkedList) 来实现栈











# ArrayDeque基于 ‘循环数组’ ，实现了Deque<E>接口，无同步开销；
1. ArrayDeque：轻量、高效，专为Deque、Stack、Queue设计
    常用方法：
        1. 作为栈
            push(E e)
            pop()
            peek()

        2. 作为队列
            offer(E e)
            poll()
            peek()

        3. 作为双端队列
            offerFirst()    offerLast()
            pollFirst()     pollLast()
            peekFirst       peekLast()

        4. 其他
            size()
            isEmpty()
            contains(Object o)
            iterator()                  // 慎用
            descendingIterator()        // 反向遍历





# LinkedList基于 ’双向链表‘ ，实现了List<E>、Deque<E>接口，插入、删除的操作很快
2. LinkedList：适合需要频繁在中间插入/删除且需要索引访问的场景
    常用方法：
        1. 作为List
            add(int index, E e)
            get(int index)
            set(int index, E e)
            remove(int index)
            indexOf() / lastIndexOf()



        2. 作为双端队列
            addFirst(e) / offerFirst(e)
            addLast(e) / offerLast(e)
            removeFirst() / pollFirst()
            removeLast() / pollLast()
            getFirst() / peekFirst()
            getLast() / peekLast()



        3. 作为栈（非最优）
            push(E e)
            pop()
            peek()

        
        4. 作为队列
            offer(e)
            poll()
            peek()

        
        5. 其他
            size()
            isEmpty()
            contains(Object o)
            iterator()                  // 正向遍历
            descendingIterator()        // 反向遍历
            listIterator()              // 支持双向遍历和修改的迭代器





# ArrayList是基于 ’动态数组‘ 实现的列表，实现了List<E>
# 初始容量为10，不足时扩容为1.5倍，操作是复制数组
3. ArrayList：适合频繁随机访问、尾插 / 尾删的场景
    常用方法；
        add(E, e)
        add(int index, E e)
        addAll()

        get(int index)
        set(int index, E e)

        remove(int index)
        remove(Object o)
        removeAll()
        retainAll()

        size()
        isEmpty()
        contains(Object o)
        indexOf(Object o)
        lastIndexOf(Object o)

# ArrayList 的迭代器是 fail-fast：如果在迭代过程中集合被修改（除迭代器自身方法外），会抛 ConcurrentModificationException
        Iterator<E> iterator()
        listIterator<E> listIterator()


        Object[] toArray()
        <T> T[] toArray(T[] a)
        List<E> subList(int from, int to)


        Object clone()          // 返回一个浅拷贝的ArrayList实例

        trimToSize()            // 把数组大小调整为实际元素个数，节省空间
        ensureCapacity()        // 预设最小容量，避免频繁扩容

        equals(Object o)
        hashCode()
        toString()





# ArrayList相较于LinkedList的优点：
1. 随机访问更快
2. 占用内存小
3. 尾部插入操作的效率相当
4. 是默认的List实现
