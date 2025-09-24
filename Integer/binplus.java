
// 输入两个表示二进制的字符串，计算它们的和，并返回二进制字符串
public class binplus {
    public String add(String a, String b) {
        StringBuilder res = new StringBuilder();
        // i,j指向a,b的最后一位,从低位开始计算，carry表示进位
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;


        // 循环处理字符串a，b的每一位
        while(i >= 0 || j >= 0) {

            // i >= 0,i--,j >= 0,j--，这是典型的逆序遍历，从低位开始计算
            // 这样能确保两个字符串的每一位都能被计算到，不够的往前补0就行了
            // 符合条件时，a.charAt(i--) - '0'，将0、1序列的字符串转换为数字0、1（ASCII码转换）
            // 不符合条件时，此时i < 0,直接使用0填充
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;

            
            // 二进制是满2进1，sum的可能结果是0、1、2、3
            // 所以需要判断sum是否大于等于2，大于等于2时，需要进位
            // 进位时，sum需要减去2，因为满2进1
            // carry是计算进位，currentBit是计算当前位
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            int currentBit = sum >= 2 ? sum - 2 : sum;
            res.append(currentBit);       
        }

        // 当i,j都计算完了，但是如果还存在进位，比如：111 + 111，还需要在最高位补1
        // 因为是逆序遍历，所以使用append()加到末尾，后面再反转
        if(carry == 1) {
            res.append(1);
        }
        // 因为是从最后一位开始计算，所以最后需要反转一下
        return res.reverse().toString();
    }
}
