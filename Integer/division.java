
// 输入两个int整数，进行除法并返回商，不能使用 * 、/ 、% 运算符
public class division {
    public int divide(int dividend, int divisor) {
        // 被除数是int最小值-2^31，并且除数为-1时，会溢出
        if(dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        
        // 把被除数和除数，都改成负数，避免发生溢出
        // 因为只有被除数和除数两个数，所以negative = 2
        int negative = 2;
        if(dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if(divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int res = diviSion(dividend, divisor);
        // 如果除数和被除数是一正一负，那就返回-res
        return negative == 1 ? -res : res;
    }


    public int diviSion(int dividend, int divisor) {
        int res = 0;
        
        while(dividend <= divisor) {
            int val = divisor; //val临时变量，存储除数的倍数
            int quotient = 1; // 商
        
        // 关键优化，倍增除数
        // val翻倍一次，quotient也会跟着翻倍
            while(val > 0xc0000000 && dividend <= val + val) {
                quotient += quotient;
                val += val;
                }
                res += quotient;
                dividend -= val;
            }
        return res;
    }
}
