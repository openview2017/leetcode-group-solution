public class main0732 {
    
}


class MyCalendarThree {
    TreeMap<Integer, Integer> delta;

    public MyCalendarThree() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }
}

/*abstract
Time Complexity: O(N^2)O(N 
2
 ), where NN is the number of events booked. For each new event, we traverse delta in O(N)O(N) time. In Python, this is O(N^2 \log N)O(N 
2
 logN) owing to the extra sort step.

Space Complexity: O(N)O(N), the size of delta
*/