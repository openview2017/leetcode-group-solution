import java.util.TreeMap;

public class main0731 {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked. 
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked. 
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked. 
        System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.        
    }
}


class MyCalendarTwo { // tc: o(nlogn + n2), sc: o(n)
    TreeMap<Integer, Integer> calendar; // key: time, value: count
    public MyCalendarTwo() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);        
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int count = 0;
        for (int val : calendar.values()) {
            count += val;
            if (count >= 3) {
                calendar.put(start, calendar.getOrDefault(start, 0) - 1);        
                calendar.put(end, calendar.getOrDefault(end, 0) + 1);
                if (calendar.get(start) == 0) calendar.remove(start);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */