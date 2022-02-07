/*
1376. Time Needed to Inform All Employees
Medium


A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

 

Example 1:

Input: n = 1, headID = 0, manager = [-1], informTime = [0]
Output: 0
Explanation: The head of the company is the only employee in the company.
Example 2:


Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.
 

Constraints:

1 <= n <= 105
0 <= headID < n
manager.length == n
0 <= manager[i] < n
manager[headID] == -1
informTime.length == n
0 <= informTime[i] <= 1000
informTime[i] == 0 if employee i has no subordinates.
It is guaranteed that all the employees can be informed.

*/

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

class Solution1376DFS0 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) if (manager[i] != -1) graph[manager[i]].add(i);
        return dfs(graph, headID, informTime);
    }
    private int dfs(List<Integer>[] graph, int u, int[] informTime) {
        int ans = 0;
        for (int v : graph[u])
            ans = Math.max(ans, dfs(graph, v, informTime));
        return ans + informTime[u];
    }
}