public class main0990 {
    public static void main(String[] args) {
        Solution0990 sol = new Solution0990();
        String[] equations;
        boolean res;

        equations = new String[]{"a==b","b!=a"};
        res = sol.equationsPossible(equations);
        System.out.println(res);
    }
}

class Solution0990 { // 17 - 22 - 23, tc/sc: o(N)
    public boolean equationsPossible(String[] equations) {
        int[] p = new int[26];
        for (int i = 0; i < 26; i++) {
            p[i] = i;
        }
        // proceed equal
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int idx1 = str.charAt(0) - 'a';                
                int idx2 = str.charAt(3) - 'a';
                merge(p, idx1, idx2);
            }
        }
        // unequal
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int idx1 = str.charAt(0) - 'a';                
                int idx2 = str.charAt(3) - 'a';
                if (find(p,idx1) == find(p,idx2)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int find(int[] p, int i) {
        while (p[i] != i) {
            p[i] = p[p[i]];
            i = p[i];
        }
        return i;
    }
    
    private void merge(int[] p, int i1, int i2) {
        p[find(p, i1)] = find(p, i2);
    }
}