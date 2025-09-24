import java.util.Random;



// 输入一个正整数数组 w，数组中的每个数字 w[i]表示下标 i 的权重，请实现一个函数 pickIndex 根据权重比例随机选择一个下标。
// 例如，如果权重数组 w 为[1, 2, 3, 4]，那么函数 pickIndex 将有 10%的概率选择 0、20% 的概率选择 1、30%的概率选择 2、40%的概率选择 3。



public class _4randomNum {
    

    private int[] sums;
    private int total;


    public _4randomNum(int[] w) {
        sums = new int[w.length];
        total = 0;
        for (int i = 0; i < w.length; i++) {
            total += w[i];
            sums[i] = total;
        }
    }


    public int randomNum() {
        Random random = new Random();

        int p = random.nextInt(total);

        int left = 0;
        int right = sums.length;

        while (left <= right) {
            int mid = right + (left - right) / 2;

            if (sums[mid] > p) {
                if (mid == 0 || sums[mid - 1] <= p) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
