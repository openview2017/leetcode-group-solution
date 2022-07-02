public class main0202 {
    
}

class Solution0202_0 {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}

class Solution0202_1 {

    public int getNext(int n) {
       int totalSum = 0;
       while (n > 0) {
           int d = n % 10;
           n = n / 10;
           totalSum += d * d;
       }
       return totalSum;
   }

   public boolean isHappy(int n) {
       int slowRunner = n;
       int fastRunner = getNext(n);
       while (fastRunner != 1 && slowRunner != fastRunner) {
           slowRunner = getNext(slowRunner);
           fastRunner = getNext(getNext(fastRunner));
       }
       return fastRunner == 1;
   }
}