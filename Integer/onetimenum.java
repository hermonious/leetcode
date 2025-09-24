

// 输入一个整数数组，只有1个数字出现了一次，其他都是3次，找出这个只出现1次的数字
public class onetimenum {

    public int singleNumber(int[] nums) {
        // 因为int是32位，所以i的范围是0到31
        // 因为每个整数都是32位，所以每个整数的第 i 个数位，都被加起来了
        // 所以bitSums[i]，保存的就是所有整数的第 i 个数位之和
        // 因为只有1个数字出现了1次，其他都是3次，所以bitSums[i] % 3，就是那个只出现1次的数字的第 i 个数位
        // 所以，从低到高，把所有的bitSums[i] % 3，拼接起来，就是那个只出现1次的数字的二进制表示
        // 把二进制表示转换为10进制，就是那个只出现1次的数字
        int[] bitSums = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                // 把num右移31-i位，再和1做与运算，就可以得到num的第31-i位
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++) {
            // 把bitSums[i] % 3，左移i位，再和res做或运算，就可以得到res的第i位
            res = (res << 1) + bitSums[i] % 3;
        }
        return res;
    }
}
