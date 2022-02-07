import java.util.*;

public class main1376 {
    public static void main(String[] args) {
        Solution1376 sol = new Solution1376();

        int n, headID, longestTime;
        int[] manager, informTime;
        n = 1;
        headID = 0;
        manager = new int[]{-1}; 
        informTime = new int[]{0};

        longestTime = sol.numOfMinutes(n, headID, manager, informTime);
        System.out.println(longestTime);
    }
}

/*
method 1: dfs bottom up
calculate the time cost of each id member and find the max
each member calcuation using dfs
base case: no personal manager
           add the time cost of personal manager to the current member
tc: o(n), sc: o(n or height)

*/
class Solution1376 { // 
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        int len = manager.length;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }
    
    private int dfs(int id, int[] manager, int[] informTime) { // time to call the member of id
        if (manager[id] != -1) {
            informTime[id] += dfs(manager[id], manager, informTime);
            manager[id] = -1;           
        }
        return informTime[id];
    }
}

/*abstract
https://leetcode.com/problems/time-needed-to-inform-all-employees/discuss/533109/JavaPython-BFSDFS-Solutions-Clean-code
*/

class Solution1376BFS {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) if (manager[i] != -1) graph[manager[i]].add(i);
        Queue<int[]> q = new LinkedList<>(); // Since it's a tree, we don't need `visited` array
        q.offer(new int[]{headID, 0});
        int ans = 0;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int u = top[0], w = top[1];
            ans = Math.max(w, ans);
            for (int v : graph[u]) q.offer(new int[]{v, w + informTime[u]});
        }
        return ans;
    }
}