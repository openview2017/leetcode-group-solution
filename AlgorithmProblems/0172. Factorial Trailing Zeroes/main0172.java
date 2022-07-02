public class main0172 {
    
}

class Solution0172 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int currentFactor = i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;        
    }
}