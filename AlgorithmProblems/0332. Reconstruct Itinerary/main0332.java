<<<<<<< HEAD
import java.util.*;
=======
/*
https://leetcode.com/problems/reconstruct-itinerary/
https://leetcode.cn/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
                       ┌─────────┐
                       │         │
      ┌───────────────▶│   SFO   │
      │                │         │
      │                └─────────┘
┌─────────┐               
│         │             
│   JFK   │               
│         │                 
└─────────┘                
    │  ▲               ┌─────────┐
    │  └───────────────│         │
    │                  │   ATL   │
    └─────────────────▶│         │
                       └─────────┘


- Time Complexity: O(ElogE)
- Space Complexity:  O(E)

欧拉回路 / 欧拉通路问题

- 「欧拉图」、「半欧拉图」的定义
    - 通过图中所有边恰好一次且行遍所有顶点的通路称为欧拉通路；
    - 通过图中所有边恰好一次且行遍所有顶点的回路称为欧拉回路；
    - 具有欧拉回路的无向图称为欧拉图；
    - 具有欧拉通路但不具有欧拉回路的无向图称为半欧拉图
- 本题可以简化为给定起点的一笔画问题
- 本题保证至少存在一种合理的路径，也就是说图是一个欧拉图或者半欧拉图

- DFS + PQ Greedy Solution
    - 因为保证为欧拉图或半欧拉图 -> 至多有一个死胡同
    - 死胡同会先入栈
    - 最终将栈中的元素依次出栈，即为路径
*/
>>>>>>> 37d460e40ee914a993ec3dca25cae948b7803c95

public class main0332 {
    public static void main(String[] args) {
        Solution0332 sol = new Solution0332();
        String[][] ticket = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (String[] t: ticket) {
            tickets.add(Arrays.asList(t));
        }
        List<String> res = sol.findItinerary(tickets);
        System.out.println(res.toString());
    }
}

class Solution0332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }

        res.addFirst(dep);
    }
}
