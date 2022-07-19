import java.util.*;

class Solution0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        res.add(cur);
        prev = cur;
        for (int i = 1; i < numRows; i++) {
            cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < prev.size(); j++) {
                cur.add(prev.get(j) + prev.get(j-1));
            }
            cur.add(1);
            res.add(cur);
            prev = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution0118 sol = new Solution0118();
        int numRows = 5;
        List<List<Integer>> res = sol.generate(numRows);
        System.out.println(Arrays.deepToString(res.toArray()));
    }
}