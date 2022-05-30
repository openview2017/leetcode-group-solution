public class main0056 {
    public static void main(String[] args) {
        
    }
}
class Solution { // 37 - 41
    public int[][] merge(int[][] intervals) {
        Deque<int[]> deque = new ArrayDeque<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] != i2[0] ? (i1[0] - i2[0]) : (i1[1] - i2[1]));
        for (int[] intv : intervals) {
            if (deque.isEmpty() || deque.peekLast()[1] < intv[0]) {
                deque.offerLast(intv);
            } else {
                intv[0] = Math.min(intv[0], deque.peekLast()[0]);                
                intv[1] = Math.max(intv[1], deque.peekLast()[1]);
                deque.pollLast();
                deque.offer(intv);
            }
        }
        return deque.toArray(new int[deque.size()][]); // !!!
    }
}