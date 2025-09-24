

/*
 *  动态数组实现List
 *  List的方法汇总
 */
public class _3list {
    

    // 初始化
    List<Integer> res = new ArrayList<>();

    Integer[] nums = new Integer[]{1,2,3,4,5};
    List<Integer> result = new ArrayList<>(Arrays.asList(nums));



    
# java.util.List的常用方法


# 1. 继承Collection的
    size()                         // 相当于length
    isEmpty()
    contains(Object o)             // 是否包含
    iterator()                     // 返回迭代器
    toArray()                      // 转成数组
    add(E e)                       // 末尾插入
    remove(Object o)               // 删除第 1 个匹配的元素
    equals(Object o)               // 2个对象是否相等
    hashcode()                     // 返回哈希码

    containsAll()
    addAll()
    removeAll()
    retainsAll()




# 2. List新增 / 重写的
    get(int index)                 // 指定索引获取
    set(int index, E element)      // 指定索引修改
    add(int index, E element)      // 指定索引插入
    remove(int index)              // 指定索引删除
    indexOf(Object o)              // 返回第 1 个匹配元素的索引，不存在返回 -1
    lastIndexOf(Object o)          // 返回最后 1 个匹配元素的索引
    
    








    


    



}
