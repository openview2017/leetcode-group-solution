import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingli on 4/21/22.
 */

/*
* Instructions:
* 找出一个数组中一个数出现次数和这个数相等的数， 例如 A：[3, 1, 4, 5, 3, 2, 1, 3] return 3，多种情况的话返回最大的数
* */
public class FrequencyFilter {

    public static void main(String[] args) {
        FrequencyFilter test = new FrequencyFilter();
        int[] arr = new int[] {1,2,3,3,2,1,3};
        System.out.println(test.findValueEqualFrequency(arr));
    }
    public int findValueEqualFrequency(int[] arr) {
        if (arr == null || arr.length == 0)  return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                max = Math.max(entry.getKey(), max);
            }
        }
        return max;
    }
}
