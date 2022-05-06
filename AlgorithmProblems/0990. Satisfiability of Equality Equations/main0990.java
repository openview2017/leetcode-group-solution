public class main0990 {
    public static void main(String[] args) {
        Solution0990 sol = new Solution0990();
        String[] equations;
        boolean res;

        equations = new String[]{"a==b","b!=a"};
        res = sol.equationsPossible(equations);
        System.out.println(res);
 
        equations = new String[]{"a==b","b==a"};
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

class Solution0990BFS { // 58 - 09
    public boolean equationsPossible(String[] equations) {
        int[][] eq = new int[26][26]; // 0-not, 1-equal
        for (int i = 0; i < 26; i++) {
            eq[i][i] = 1;
        }
        // process equals
        for (String s : equations) {
            
            if (s.charAt(1) == '!') {
                if (s.charAt(0) == s.charAt(3)) {
                    return false;
                }   
                continue;
            }
            //System.out.println(1);
            int idx1 = s.charAt(0) - 'a';            
            int idx2 = s.charAt(3) - 'a';
            eq[idx1][idx2] = 1;            
            eq[idx2][idx1] = 1;
        }
        // process not equal
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                // if (eq[s.charAt(0)-'a'][s.charAt(3)-'a'] == 0) {
                //     return false;
                // }   
                continue;
            }
            //System.out.println(2);
            int idx1 = s.charAt(0) - 'a';            
            int idx2 = s.charAt(3) - 'a';
            //System.out.println(bfs(eq, idx1, idx2));
            if (bfs(eq, idx1, idx2)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int[][] eq, int idx1, int idx2) { // check equal
        boolean[] visited = new boolean[26];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(idx1);
        visited[idx1] = true;
        while (!queue.isEmpty()) {
            int tmp = queue.pollFirst();
            if (eq[tmp][idx2] == 1 || eq[idx2][tmp] == 1) {
                return true;
            }            
            for (int i = 0; i < 26; i++) {
                if (visited[i]) continue;
                if (eq[tmp][i] == 1) {
                    queue.offerLast(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}