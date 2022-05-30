public class main0050 {
    public static void main(String[] args) {
        Solution0050 sol = new Solution0050();
        double x = 2.00000;
        int n = 10;
        double res = sol.myPow(x, n);
        System.out.println(res);
    }
}


class Solution0050 {
    public double myPow(double x, long n) {
        if (x == 0.0 && n != 0) {
            return x;
        }
        if (n == 0) {
            return (double) 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            x = (double) 1.0 / x;
            n = -n;           
        }
        double ans = 1.0;
        while (n != 0) {
            if ((n & 1L) != 0) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}