public class main2110 {
    public static void main(String[] args) {
        
    }
}

class Solution2110 {
    public long getDescentPeriods(int[] prices) {
        long temp = 1; // longest desc
        long count = 1;
        //long prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1] - 1) {
                temp++;
            } else { 
                temp = 1;
            }
            count += temp;
            //System.out.print(count + " ");
        }
        return count;
    }
}
/*

3 2      1    4
1 2      3    1
1 1+2  3+3  6+1

*/