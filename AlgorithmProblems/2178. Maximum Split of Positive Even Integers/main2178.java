public class main2178 {
    
}


class Solution2178 { //42 - 47
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 != 0) return res;
        long i = 2;
        while (i <= finalSum) {
            finalSum -= i;
            res.add(i);
            i += 2;
        }
        if (finalSum > 0) {
            long last = res.get(res.size() - 1);
            res.remove(res.size() - 1);
            res.add(finalSum + last);
        }
        return res;
    }
}