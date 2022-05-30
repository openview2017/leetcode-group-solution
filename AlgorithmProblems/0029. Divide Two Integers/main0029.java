public class main0029 {
    public static void main(String[] args) {
        Solution0029 sol = new Solution0029();
        int dividend = 10, divisor = 3;
        int res = sol.divide(dividend, divisor);
        System.out.println(res);
    }
}

class Solution0029 { // 41 - 47, Binary Long Division
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int div1 = Math.abs(dividend), div2 = Math.abs(divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((div1 >>> i) - div2 >= 0) {
                res += (1 << i);
                div1 -= (div2 << i);
            }
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}