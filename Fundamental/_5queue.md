



Queue的常用方法
# 推荐使用(成功true，失败false)                      不推荐使用(失败抛出异常)
    offer(e)                                            add(e)
    poll()                                              remove()
    peek()                                              element()


注意事项：
1. 不允许插入 ‘null’，因为poll()和peek()使用‘null’来表示空
2. ArrayDeque、LinkedList不是线程安全的，多线程应该使用ConcurrentLinkedQueue / BlockingQueue实现
3. Queue是接口，不能直接实例化，必须使用具体的实现类



