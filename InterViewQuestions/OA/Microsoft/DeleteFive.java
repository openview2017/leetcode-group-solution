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
        System.out.println(test.deleteFive(955));
    }
    public int deleteFive(int num) {
        if (num == 0) return num;
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        int removalIndex = -1;
        boolean findFive = false;
        if (num > 0) {
            //remove first 5 with next char greater than 5, otherwise
            for (int i = 0; i < arr.length - 1; i++) {

            }
        } else {
            //remove
        }

        if (!findFive) return num;

        return 0;
    }
}
