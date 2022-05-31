import java.util.*;

public class main0729 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
    } // tc: o(nlogn)
}


class MyCalendar { 
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        this.map = new TreeMap<>();
    }
    //         [p    p.end)       |      |    [n     
    //        prev               start  end  next
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start); // use map.get(prev) later       
        Integer next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */