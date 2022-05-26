public class main0444 {
    
}


class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> graph = buildGraph(sequences);
        List<Integer> topoOrder = getTopoOrder(graph);
        
        if (topoOrder == null || topoOrder.size() != nums.length) {
            return false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != topoOrder.get(i)) {
                return false;
            }
        }
        
        return true;
    }

    
    private Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> seqs){
        Map<Integer, Set<Integer>> graph = new HashMap();
        for (List<Integer> seq: seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (!graph.containsKey(seq.get(i))) {
                    graph.put(seq.get(i), new HashSet<Integer>());
                }
            }            
        }
        
        for (List<Integer>  seq: seqs) {
            for (int i = 1; i < seq.size(); i++) {
                graph.get(seq.get(i-1)).add(seq.get(i));
            }
        }
        
        return graph;
    }
    
    
    private List<Integer> getTopoOrder(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegrees = getIndegrees(graph);
        Queue<Integer> queue = new LinkedList();
        List<Integer> topoOrder = new ArrayList();
        
        for (Integer node : graph.keySet()) {
            if (indegrees.get(node) == 0) {
                queue.offer(node);
                topoOrder.add(node);
            }
        }
        
        while(!queue.isEmpty()) {
            if (queue.size() > 1){
                return null;
            }
            
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    topoOrder.add(neighbor);
                }                
            }                        
        }
        
        if (graph.size() == topoOrder.size()) {
            return topoOrder;
        }

        return null;
        
    }
    
    private Map<Integer, Integer> getIndegrees(Map<Integer, Set<Integer>> graph){
        Map<Integer, Integer> indegrees = new HashMap();
        for (Integer node : graph.keySet()) {
            indegrees.put(node, 0);
        }
        
        for (Integer node: graph.keySet()) {
            for (Integer neighbor : graph.get(node)) {
                indegrees.put(neighbor, indegrees.get(neighbor) + 1);
            }
        }
        
        return indegrees;
        
    } 
    
}