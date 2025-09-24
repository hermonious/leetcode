
// 给一个 0 到 n 的整数数组，输出它们对应二进制中1的个数，以数组返回
public class numof1 {

    // 动态规划思想
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; ++i) {
            //1.使用&
            // res[i] 表示 i 中 1 的个数
            // 表达式：i & (i - 1)，清除 i 二进制中最右边的一个 1
            // 所以：i 中 1 的个数 = i & (i - 1) 中 1 的个数 + 1
            res[i] = res[i & (i - 1)] + 1;



            //2.使用>>
            // i >> 1,将i的二进制表示右移一位，相当于少了最后一位
            // 再使用 i & 1，将i的二进制表示的最后一位取出来
            // 所以：i 中 1 的个数 = i >> 1 中 1 的个数 + i 的最后一位
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }



    // 3.普通方法
    public int[] countBits2(int num) {     
        int[] result = new int[num + 1];     
        for (int i = 0; i <= num; ++i) {         
            int j = i; 
            while (j != 0) { 
                result[i]++; 
                j = j & (j - 1); 
            } 
        }
        return result; 
    } 
}
