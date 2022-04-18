import java.util.*;

public class main2007 {
    public static void main(String[] args) {
        int[] changed, res;
        Solution2007 sol = new Solution2007();

        changed = new int[]{1,3,4,2,6,8};
        res = sol.findOriginalArray(changed);
        System.out.println(Arrays.toString(changed));
        System.out.println(Arrays.toString(res));
        System.out.println();

        changed = new int[]{6,3,0,1};
        res = sol.findOriginalArray(changed);
        System.out.println(Arrays.toString(changed));
        System.out.println(Arrays.toString(res));
        System.out.println();

        changed = new int[]{1};
        res = sol.findOriginalArray(changed);
        System.out.println(Arrays.toString(changed));
        System.out.println(Arrays.toString(res));
        System.out.println();
        
    }
}


class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : changed) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int index = 0;
        for (int key : count.keySet()) {
            if (key == 0) {
                int freq = count.get(key);
                if (freq % 2 != 0)
                    return new int[0];
                for (int i = 0; i < freq / 2; i++) {
                    res[index++] = 0;
                }
            } else if (count.get(key) > 0) {
                while (key % 2 == 0 && count.containsKey(key / 2))
                    key /= 2;
                while (count.containsKey(key)) {
                    int freq = count.get(key);
                    if (freq > 0) {
                        if (freq >  count.getOrDefault(key + key, 0))
                            return new int[0];
                        for (int i = 0; i < freq; i++) {
                            res[index++] = key;
                        }
                        count.put(key, 0);
                        count.put(key + key, count.get(key + key) - freq);
                    }
                    key += key;
                }
            }
        }
        return res;
    }
    }