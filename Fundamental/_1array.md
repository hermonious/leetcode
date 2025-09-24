import java.util.concurrent.*;

/* 
 * 初始化、随机访问、（插入、删除、查找）、遍历、扩容
 */
public class _1array {
    
    // 1. 初始化
    int[] array = new int[5]; // {0,0,0,0,0}
    int[] nums = {1,2,3,4,5};


    // 2. 随机访问
    public int cccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机抽取一个数字
        int index = ThreadLocalRandom.current().nextInt(0, nums.length);
        int num = nums[index];
        return num;
    }


    // 3. 插入、删除、查找（1个元素）

    // 索引 index 之后的所有元素后移 1 位
    public void insert(int[] nums, int num, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }



    // 索引 index 之后的所有元素前移 1 位
    public void remove(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }



    public int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }




    // 4. 遍历数组元素求和
    public int traverse(int[] nums) {
        int sum = 0;

        // 索引遍历
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 增强for遍历
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }



    // 5. 扩容（建立新数组，并复制）
    public int[] extend(int[] nums, int enlarge) {
        int[] res = new int[nums.length + enlarge];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}











# java.util.Arrays的常用方法        (所有基本类型 + Object[])

1. sort() 
    1.sort(int[] a) //升序排序   sort(int[] a, int from, int to)// 子区间排序
    2.sort(T[] a) // 要求T实现Comparable接口
    3.sort(T[] a, Comparator<? super T> c)  // 使用自定义比较器


2. binarySearch()

3. equals()
    1.equals(int[] a, int[] b)      // 比较数组内容是否相同
    2.Objects.equals(Object[] a, Object[] b)        // 比较对象数组         


4. fill()
    1.fill(int[] a, int val)        // 全部填充
    2.fill(int[] a, int from, int to, int val)
    3.fill(Object[] a, Object val)  // 对象数组填充


# 5. List<T> asList(T....a)     // 把数组转成List
# 返回的List不能进行add、remove操作；与原来数组共享数据；基本数据类型数组会报错

6. toString()
    1.toString(int[] a)         // 数组转成字符串


7. copyOf()
    1.copyOf(int[] old, int length)         // 复制旧数组，指定新的长度
    2.copyOfRange(int[] old, int from, int to)      // 复制子区间

