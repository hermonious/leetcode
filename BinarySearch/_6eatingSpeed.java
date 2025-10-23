



// 狒狒很喜欢吃香蕉。一天它发现了 n 堆香蕉，第 i 堆有 piles[i] 根香蕉。
// 门卫刚好走开，H 小时后才会回来。狒狒吃香蕉喜欢细嚼慢咽，但又想在门卫回来之前吃完所有的香蕉。
// 请问狒狒每小时至少吃多少根香蕉？如果狒狒决定每小时吃 k 根香蕉，而它在吃的某一堆剩余的香蕉的数目少于 k，那么它只会将这一堆的香蕉吃完，下一个小时才会开始吃另一堆的香蕉。 
public class _6eatingSpeed {
    public int eatingSpeed(int[] piles, int h) {
        
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1; 
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = getHours(piles, mid); // 改为 long

            if (hours <= h) {
                if (mid == 1 || getHours(piles, mid - 1) > h) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 返回类型改为 long，内部累加变量也用 long
    public long getHours(int[] piles, int speed) {
        long hours = 0; // 关键：用 long 防止溢出
        
        for (int pile : piles) {
            // (pile + speed - 1) / speed 是向上取整
            // pile 和 speed 都是 int，但加法可能接近溢出边界，
            // 不过本题 pile <= 1e9, speed >= 1，所以 (pile + speed - 1) 不会溢出 int，
            // 但为了绝对安全，也可以写成：(long) pile + speed - 1
            hours += (pile + (long) speed - 1) / speed;
        }
        return hours;
    }
}
