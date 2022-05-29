public class main1154 {
    public static void main(String[] args) {
        Solution1154 sol = new Solution1154();
        date = "2019-01-09";
        int count = sol.dayOfYear(date);
        System.out.println(count);
    }
}


class Solution1154 {
    public int dayOfYear(String date) {
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] ds = date.split("-");
        int year = Integer.parseInt(ds[0]);        
        int month = Integer.parseInt(ds[1]);
        int day = Integer.parseInt(ds[2]);
        System.out.println(year + "_" + month + "_" + day);
        int count = 0;
        
        // count += day;
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeap(year)) {
                count += 1;
            }
            count += days[i-1];
            //System.out.println(count);
        }
         count += day;
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
} // https://leetcode.com/problems/day-of-the-year/discuss/355880/Simple-Java-Solution-easy-to-understand-GregorianCalendar