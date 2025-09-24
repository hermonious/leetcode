



// ：狒狒很喜欢吃香蕉。一天它发现了 n 堆香蕉，第 i 堆有 piles[i] 根香蕉。
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
            int hours = getHours(piles, mid);

            if (hours <= h ) {
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



    public int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
