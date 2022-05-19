public class main0901 {
    
}

class StockSpanner {
    Deque<int[]> stack;
    
    public StockSpanner() { // [price, count]
        this.stack = new ArrayDeque<>();        
    }
    
    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peekLast()[0] <= price) {
            count += stack.pollLast()[1];
        }
        stack.offerLast(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 https://leetcode.com/problems/online-stock-span/discuss/168311/C%2B%2BJavaPython-O(1)
 */