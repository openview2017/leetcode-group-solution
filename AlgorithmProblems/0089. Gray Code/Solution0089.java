import java.util.*;

public class Solution0089 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << (i-1)));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution0089 sol = new Solution0089();
        int n = 5;
        List<Integer> res = sol.grayCode(n);
        System.out.println(Arrays.toString(res.toArray()));
    }    
}
