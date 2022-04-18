/*
method: bfs + hashmap
tc:o(N)
sc:o(n)

*/

import java.util.*;

public class main0582 {
    public static void main(String[] args) {
        Solution0582 sol = new Solution0582();
        List<Integer> pid, ppid, res;
        int kill;
        
        pid = Arrays.asList(1,3,10,5);
        ppid = Arrays.asList(3,0,5,3);
        kill = 5;

        res = sol.killProcess(pid, ppid, kill);
        System.out.println(Arrays.toString(res.toArray()));
    }
}


class Solution0582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        Map<Integer, List<Integer>> children = new HashMap<>();
        
        for(int i=0; i<pid.size(); i++){
            Integer parent = ppid.get(i);
            children.putIfAbsent(parent, new ArrayList<>());
            children.get(parent).add(pid.get(i));
        }
        
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        
        while(!q.isEmpty()){
            Integer current = q.poll();
            ans.add(current);
            q.addAll(children.getOrDefault(current,new LinkedList<>()));
        }
        
        return ans;
    }
}
