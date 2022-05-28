public class main0123 {
    public static void main(String[] args) {
        solution0123 sol = new solution0123();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int res = sol.maxProfit(prices);
        System.out.println(res);
    }
}

class solution0123{
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }    
}
