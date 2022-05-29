public class main1360 {
    
}


class Solution1360 { // 44 - 54
    static int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDays(conv(date2)) - countDays(conv(date1)));
    }
    private int countDays(int[] d) {// days from 0000-01-01
        int count = 0;
        count += (d[0]-1) * 365;
        count += (d[0]-1) / 4 - (d[0]-1) / 100 + (d[0]-1) / 400;
        for (int i = 0; i < d[1] - 1; i++) {
            if (i == 1 && isLeap(d[0])) {
              count += 1;  
            }   
            count += days[i];
        }
        count += d[2];
        return count;
    }
    private boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }
    private int[] conv(String s) {
        String[] ss  = s.split("-");
        int[] res = new int[3];
        for (int i = 0; i < 3; i++) {
            res[i] = Integer.parseInt(ss[i]);
        }
        return res;
    }
}