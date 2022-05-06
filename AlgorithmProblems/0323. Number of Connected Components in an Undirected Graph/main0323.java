public class main0323 {
    public static void main(String[] args) {
        Solution0323 sol = new Solution0323();
        int n, edges[][], count;
        n = 5; 
        edges = new int[][]{{0,1},{1,2},{3,4}};
        count = sol.countComponents(n, edges);
        System.out.println(count);

    }
}

class Solution0323 { // 47 - 54, path compression
    public int countComponents(int n, int[][] edges) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        for (int[] edge : edges) {
            merge(p, edge[0], edge[1]);
        }
        
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (find(p, j) == j) {
                count++;
            }
        }
        return count;
    }
    
    private int find(int[] p, int j) {
        while (p[j] != j) {
            int tmp = p[j];
            p[j] = p[p[j]];
            j = tmp;
        }   
        return j;
    }
    
    private void merge(int[] p, int a, int b) {
        int ra = find(p, a);
        int rb = find(p, b);
        if (ra == rb) return;
        p[ra] = rb; 
    }
}