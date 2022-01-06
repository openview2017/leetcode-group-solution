/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();

        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> personalSchedule : schedule) {
            for (Interval interval : personalSchedule) {
                minHeap.offer(interval);
            }
        }
        if (minHeap.isEmpty()) return res;

        List<Interval> mergedInterval = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Interval cur = minHeap.poll();
            Interval next = minHeap.isEmpty() ? null : minHeap.peek();
            if (next == null) {
                mergedInterval.add(cur);
                break;
            }
            int curStart = cur.start;
            int curEnd = cur.end;
            int nextStart = next.start;
            int nextEnd = next.end;
            if (curEnd >= nextStart) {
                minHeap.poll(); //poll out next
                cur.end = Math.max(curEnd, nextEnd);
                minHeap.offer(cur); //offer updated merge interval
            } else {
                mergedInterval.add(cur);
            }
        }
        //now we have merged interval in list
        for (int i = 1; i < mergedInterval.size(); i++) {
            int start = mergedInterval.get(i - 1).end;
            int end = mergedInterval.get(i).start;
            Interval common = new Interval(start, end);
            res.add(common);
        }
        return res;
    }
}