public class main0231 {
    public static void main(String[] args) {
        Solution0231 sol = new Solution0231();
        int n = 1;
        boolean res = sol.isPowerOfTwo(n);
    }
}
class Solution0231 {
    public boolean isPowerOfTwo(int n) {
      if (n == 0) return false;
      long x = (long) n;
      return (x & (x - 1)) == 0;
    }
  }