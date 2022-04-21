/**
 * Created by yingli on 4/20/22.
 */

/**
* 给一个数字（可正可负），数字里面至少包括一个数字5，求删除一个5之后的最大值。
 【-9995】-》-999
 【15859】-〉1859
 【-15853】 -》-1583
 【5000】 -‍‍‍‌‌‌‍‌‌‌‌‍‍‍‌‍‌‍‍〉0

* */
public class DeleteFive {
    public static void main(String[] args) {
        DeleteFive test = new DeleteFive();
        System.out.println(test.deleteFive(15859));
        System.out.println(test.deleteFive(-1583));
        System.out.println(test.deleteFive(5000));
        System.out.println(test.deleteFive(-1596259));
        System.out.println(test.deleteFive(5));

    }
    public int deleteFive(int num) {
        if (num == 0) return num;

        String str = String.valueOf(num);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '5') {
                res = Math.max(res, remove(num, str.length() - i));
            }
        }
        return res;
    }

    private int remove(int num, int k) {

        boolean positive = num > 0;
        num = Math.abs(num);


        int part1 = (num / (int)Math.pow(10, k)) *  (int)(Math.pow(10, k - 1));

        int part2 = num % (int)(Math.pow(10, k - 1));

        return positive ? (part1 + part2) : -1 * (part1 + part2);
    }
}
