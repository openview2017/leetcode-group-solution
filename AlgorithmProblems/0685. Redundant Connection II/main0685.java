public class main0685 {
    
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            // 默认的父结点就是自己;
            parent[i] = i;
        }
        // 维护导致冲突的边和导致环路出现的边;
        // 由于只有一条附加的边，因此最多有一条导致冲突的边和一条导致环路出现的边。
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            // 访问边 [node1, node2]，边 node1 --> node2 中，node1 是 node2 的父结点;
            int node1 = edge[0];
            int node2 = edge[1];
            // 将结点加入到并查集（处理后的图中）;
            if (parent[node2] != node2) {
                // 如果 !=，说明 node2 有父结点！！
                // 当前边 [node1, node2] 是另外一个冲突边，前一条冲突边 [parent[node2], node2] 已经加入到了并查集中；
                // 注意1：如果发现了「冲突」边，仅将后出现的那条记录下来，而不加到图（并查集）中。
                // 注意2：如何确定 后出现的 这条冲突边 i 是否在环中呢？--> 关键在于下面的 cycle
                //       如果 i 在环中，那么 cycle == -1，因为后出现的 i 不会加入到并查集中，所以找不到环；
                //       如果 i 不在环中，那么 cycle != -1
                conflict = i;
                
            } else {
                // 如果 ==, 说明 node2 还没有父结点, 按照题意父结点就是 node1，[node1, node2] 是 node2 第一条入边
                // 设置 parent[node2] = node1（这里设置后，如果 node2 有另外冲突边，if 就能记录下来）
                // 接着，通过并查集判断设置后的 node1/2 的祖先情况（是否成环）；
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i; // 一样，那么说明 i 边导致其成环;
                } else {
                    uf.union(node1, node2); // 不一样，那就合并操作;
                }
            }
        }
        
        // 从上面可以看到，如果冲突和环同时存在的话一定不是同一条边；
        // 因为只增加了一个边，所以一定是有环的，但是未必有冲突，因为是有向图；
        
        // 上面在遍历的时候，如果找到了冲突边，只有第一条会被加入到并查集中；
        if (conflict < 0) { // 无冲突边，只有环，那就直接去掉这个边就行了;
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            // 有冲突边，也就是说 edges[conflict][1] 有两个父结点了.
            int[] conflictEdge = edges[conflict];
            // 判断下是否有环；
            if (cycle >= 0) {
                // 有环, 要去除的是先出现的那条，因为 conflict 后出现的冲突边，如果仍有环说明其不在环中；
                // 那为什么 parent[conflictEdge[1]], conflictEdge[1] 就是先出现的那条边呢
                // 我们知道 conflictEdge[0] --> conflictEdge[1] 是一条冲突边，而我们只会记录后出现的冲突边
                // 先出现的冲突边一定是 conflictEdge[1] 和其另外一个父结点构成的；另外一个父结点显然是 parent[conflictEdge[1]]！ 
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                // 无环，说明后出现的冲突边在环中，那就删除掉后出现的冲突边;
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index1)] = parent[find(index2)];
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}