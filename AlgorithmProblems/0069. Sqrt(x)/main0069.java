public class main0069 {
    
}


class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int lo = 2, hi = x / 2, mid = 2;
        long num;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            num = (long) mid * mid;
            if (num == x) {
                return mid;
            } else if (num > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}