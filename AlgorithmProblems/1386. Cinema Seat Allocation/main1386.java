import java.util.*;

public class main1386 {
    public static void main(String[] args) {
        Solution1386 sol = new Solution1386();
        int[][] reservedSeats;
        int n, res;

        n = 3; reservedSeats = new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        res = sol.maxNumberOfFamilies(n, reservedSeats);
        System.out.println("Input : " + Arrays.deepToString(reservedSeats) + ", " + n);
        System.out.println("Output: " + res);
    }
}


class Solution1386 { // 37 - 45
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int[] reserveSeat : reservedSeats) {
            int prev = rowMap.getOrDefault(reserveSeat[0], 0);
            // prev |= (1 << reserveSeat[1]);// !!! x
            prev |= (1 << (10 - reserveSeat[1]));
            rowMap.put(reserveSeat[0], prev);
        }
        int res = (n - rowMap.size()) * 2;
        for (int row : rowMap.keySet()) {
            int cur = rowMap.get(row);
            if ((cur & 0b0111111110) == 0) {
                res += 2;
            } else if (((cur & 0b0001111000) == 0) || ((cur & 0b0111100000) == 0) || ((cur & 0b0000011110) == 0)) {
                res += 1;
            }
        }
        return res;
    }
    
    public int maxNumberOfFamilies0(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            map.put(seat[0], map.getOrDefault(seat[0], 0) | 1 << (10 - seat[1]));
        }
        int res = (n - map.size()) * 2;;
        for (int row : map.keySet()) {
            int seats = map.get(row);
            if ((seats & 0b0111111110) == 0)
                res += 2;
            else if ((seats & 0b0111100000) == 0 || (seats & 0b0001111000) == 0 || (seats & 0b0000011110) == 0)
                res += 1;

        }
        return res;
    }
}
// tc: o(n), sc: o(n)
// ref:  https://leetcode.com/problems/cinema-seat-allocation/discuss/546451/Java-Straightforward-solution-(bitwise)