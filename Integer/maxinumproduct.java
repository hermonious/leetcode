
// 输入一个字符串数组 words，请计算不包含相同字符的两个字符串 words[i]和 words[j]的长度乘积的最大值
public class maxinumproduct {
    
    // 使用长度为26的boolean数组来模拟哈希表，记录每个字符串中出现过的字符
    public int maxProduct(String[] words) {
        // 记录每个字符串中出现过的字符
        // 索引 i 表示字符串 words[i]
        // 索引 j 总是从 i + 1开始，避免重复比较
        // 索引 k 代表26个小写字母
        boolean[][] flags = new boolean[words.length][26];
        for(int i = 0; i < words.length; i++) {
            // 提取出words[]中的第 i 个字符串，遍历这个字符串的每个字母，转成字符数组，并标记出现过的字符
            for(char c : words[i].toCharArray()) {
                // 在二维数组flags的第i行（对应第i个字符串）的对应索引位置标记为true，表示这个字符存在于该字符串中
                flags[i][c - 'a'] = true;
            }
        }
        int res = 0;
        // 遍历两个任意的的字符串组合，判断是否有相同的字符
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {

                // 需要在循环外使用的变量，必须在循环外声明
                int k = 0;
                for(; k < 26; k++) {
                    if(flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if(k == 26) {
                    int product = words[i].length() * words[j].length();
                    res = Math.max(res, product);
                }
            }
        }
        return res;
    }








    

    // 使用整数的二进制数位记录字符串中出现过的字符，更加巧妙
    public int maxProduct2(String[] words) {
        int[] flags = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                // 关键代码
                // 数字1左移对应位数，得到一个 “只有某一位为 1，其余位为 0” 的整数
                // 然后与 flags[i] 进行按位或运算，再把结果存回 flags[i]
                flags[i] |= 1 << (c - 'a');
            }
        }

        int res = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                // 关键代码
                // 按位与运算，只有当对应位都是 1 时，结果才为 1
                // 如果结果为 0，说明两个字符串没有相同的字符
                if((flags[i] & flags[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    res = Math.max(res, product);
                }
            }
        }
        return res;
    }
}
