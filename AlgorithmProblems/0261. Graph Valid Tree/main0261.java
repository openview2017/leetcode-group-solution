import java.util.*;

public class main0261 {
    public static void main(String[] args) {
        Solution0261 sol = new Solution0261();
        int edges[][], n;
        boolean res;
        
        n = 5;
        edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        res = sol.validTree(n, edges);
        System.out.println(res);
    }
}
/* 
Variant of topological sort due to double directed edge

*/
class Solution0261 { // method: dfs; tc: o(n), sc: o(n)
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
		    return false;
        }

        // init graph     
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }   
            count++;
            dfs(visited, graph, i);
            //bfs(visited, graph, i);
        }
        return count == 1 ? true : false;
    }
    private void dfs(boolean[] visited, HashMap<Integer, List<Integer>> graph, int i) {
        visited[i] = true;
        for (int n : graph.get(i)) {
            if (!visited[n]) {
                dfs(visited, graph, n);
            }
        }
    } // 21 ms

}