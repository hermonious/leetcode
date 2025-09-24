


Java集合框架的所有重要实现类
1. Collection
    List（有序，可重复）
        ArrayList            
        LinkedList           
    Set（无序，不重复）
        HashSet            
        LinkedHashSet     
        TreeSet                 
    Queue/Deque
        LinkedList              
        ArrayDeque             
        PriorityQueue        

2. Map  
    HashMap             
    LinkedHashMap         
    TreeMap        
    ConcurrentHashMap     

            



#                                       是否有序            是否可重复                      适用情况
HashMap	            数组+链表+红黑树	    ❌	            ✅ (key一个, value多个)	    普通 Map，高性能
HashSet	            哈希表（基于 HashMap）	❌	            ✅ (一个 null)	            去重，无序
ConcurrentHashMap	数组+链表+红黑树（CAS/synchronized）❌	❌	                        高并发 Map


TreeSet	            红黑树	              ✅ (排序)	        ❌	                        去重+排序
TreeMap	            红黑树	              ✅ (排序)	        ❌	                        排序映射
LinkedHashMap	    哈希+双向链表	       ✅ (插入/访问顺序)   ✅ (value可null)	           有序 Map / LRU
LinkedHashSet	    哈希+双向链表	       ✅ (插入顺序)	        ✅	                      去重+插入顺序


ArrayList	        数组	              ✅ (插入顺序)	        ✅	                        默认 List，随机访问快
LinkedList	        双向链表	          ✅ (插入顺序)	        ✅	                        头尾增删快，实现 Queue/Deque
ArrayDeque	        循环数组	          ✅ (插入顺序)	        ❌ (最好避免)	              代替栈 / 队列
PriorityQueue	    最小堆	              ❌ (仅堆序)	        ❌	                        优先级任务，poll() 最小








1. 2种方法，更推荐传入比较器，更灵活
# 元素 / 键要么实现Comparable接口才能进行 ‘自然排序’ ：TreeSet、TreeMap
# 要么在构造时传入Comparator比较器进行 ‘自定义排序’ ：TreeSet、TreeMap、PriorityQueue


2. (Linked)HashMap和(Linked)HashSet的排序方法
    1、HashSet/LinkedHashSet	            转 TreeSet，会自动排序
        示例代码：
            HashSet<String> hashSet = new HashSet<>();
            TreeSet<String> sortedSet = new TreeSet<>(hashSet);



    2、HashMap/LinkedHashMap	            分为按照key / value排序，两种情况
        1.按照Key排序，转成 TreeMap
            HashMap<String, Integer> map = new HashMap<>();
            TreeMap<String, Integer> sortedByKey = new TreeMap<>(map);
            然后自定义 key 排序
        
        2、按照Value排序，转成 List<Map.Entry>，再调用 sort()
            1. 传统写法
                HashSet<String> hashSet = new HashSet<>();
                List<String> list = new ArrayList<>(hashSet);
                Collections.sort(list);

            2. Java8+ 的Stream流写法
                List<String> sortedList = hashSet.stream()
                                                .sorted()
                                                .collect(Collectors.toList());
