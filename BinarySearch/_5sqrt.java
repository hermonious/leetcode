



// 输入一个非负整数，请计算它的平方根。
// 正数的平方根有两个，只输出其中的正数平方根。如果平方根不是整数，那么只需要输出它的整数部分。




public class _5sqrt {
    

    public int sqrt(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 变量 mid 表示某个范围的中间值。上述代码将“mid * mid <= n”写成了“mid <= n / mid”。
            // 虽然这两个不等式在数学上等价的，但计算 mid * mid 可能会产生溢出。

            // 判断 mid^2 是否小于或等于 n。如果 mid^2 ≤ n，
            // 那么接着判断(mid+1)^2 是否大于 n。如果满足(mid+1)^2 > n，那么 mid就是 n 的平方根
            if (mid <= n / mid) {
                if ((mid + 1) > n / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
