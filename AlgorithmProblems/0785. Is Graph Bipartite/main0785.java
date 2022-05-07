public class main0785 {
    
}


class Solution0785_dfs { // 39 - 57
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, 1, i)) {
                return false;
            }
            //System.out.println(Arrays.toString(color));
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] color, int c, int i) {
        color[i] = c;
        int neiColor = -c;
        for (int nei : graph[i]) {
           // if ( (color[nei] == 0 && !dfs(graph, color, neiColor, nei)) || color[nei] != neiColor) { // correct
           if (color[nei] == c || (color[nei] == 0 && !dfs(graph, color, neiColor, nei))) {  
              return false;
            }
        }
        return true;
    }
}

class Solution0785_bfs {

    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        for (int k = 0; k < n; k++) {
            if (color[k] == 0 && !bfs(graph, color, k)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean bfs(int[][] graph, int[] color, int k) {
        color[k] = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        int c = 1;
        queue.offerLast(k);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //c = -c;
            for (int i = 0; i < size; i++) {
                int tmp = queue.pollFirst();
                for (int nei : graph[tmp]) {
                    if (color[nei] == c) {
                        return false;
                    } else if (color[nei] == 0) {
                        queue.offerLast(nei);
                        color[nei] = -c;
                    }
                }
            }
            c = -c;
        }
        return true;        
    }    
}