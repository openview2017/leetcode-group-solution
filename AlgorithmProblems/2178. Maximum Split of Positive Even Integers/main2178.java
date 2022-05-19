import java.util.*;

public class main2178 {
    public static void main(String[] args) {
        Solution2178 sol = new Solution2178();
        List<Long> res;
        long finalSum;

        finalSum = 12;
        res = sol.maximumEvenSplit(finalSum);
        System.out.println(Arrays.toString(res.toArray()));
    }
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
            // long last = res.get(res.size() - 1);
            // res.remove(res.size() - 1);
            // res.add(finalSum + last);
            res.add(finalSum + res.remove(res.size() - 1));
        }
        return res;
    }
}