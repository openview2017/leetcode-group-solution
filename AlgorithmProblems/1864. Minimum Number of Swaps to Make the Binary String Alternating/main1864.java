public class main1864 {
    public static void main(String[] args) {
        Solution1864 sol = new Solution1864();
        String s = "111000";
        int res = sol.minSwaps(s);
        System.out.println(res);
    }
}


class Solution1864 {
    public int minSwaps(String s) {
        int n = s.length();
        int onesNum = 0;
        int diff = 0;
        //一次循环解决问题
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //统计1的个数
            if (c == '1') {
                onesNum++;
            }
            //统计和”101010....“队列的差别
            if (i % 2 == 0) {
                if (c == '1') {
                    diff++;
                }
            } else {
                if (c == '0') {
                    diff++;
                }
            }
        }
        //如果队列中1和0的个数相差大于1，则不可能通过交换得到交替队列
        if (onesNum < n / 2 || onesNum > (Math.ceil(n / 2.0))) {
            return -1;
        }
        //与101010...差异点
        int timeOne = diff;
        //与010101...差异点
        int timeTwo = n - diff;
        //如果差异的数量是奇数，那么不可能通过交换变为该队列
        if (diff % 2 != 0) {
            timeOne = Integer.MAX_VALUE;
        }
        if ((n - diff) % 2 != 0) {
            timeTwo = Integer.MAX_VALUE;
        }
        //最后取差异小的数量
        return Math.min(timeOne / 2, timeTwo / 2);
    }
}
// https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/solution/minimum-number-of-swaps-to-make-the-bina-z0qy/