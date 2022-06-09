public class main2242 {
    
}


class Solution2242 {
    // 参考灵神的题解:枚举中间边+筛选两边可能的最大值
    public int maximumScore(int[] scores, int[][] edges) {
        // 节点个数
        int num = scores.length;
        // 构建图
        List<int[]>[] g = new ArrayList[num];
        // 初始化
        for (int i = 0; i < num; i++) {
            g[i] = new ArrayList();
        }
        // 遍历每条边
        for (int[] edge : edges) {
            // 边上的两个顶点
            int v1 = edge[0], v2 = edge[1];
            // 记录的与v1相连的顶点编号与分数
            g[v1].add(new int[]{scores[v2], v2});
            g[v2].add(new int[]{scores[v1], v1});
        }
        // a——x——y——b,其中枚举的是x——y这条边,那么要想和的值最大,那么就需要找出a与b的最大值
        // 找出a中不与y和b重合的最大值(肯定不与x重合,因为a是x相邻的边)
        // 同理找出b中不与x和a重合的最大值(肯定不与y重合,因为b是y相邻的边)
        // 因此找出a相邻边的最大的那三条,那么a必定会取到其中一条是符合要求的最长边(利用排序)
        for (int i = 0; i < num; i++) {
            // 当且仅当>3才需要筛选出3条边
            if (g[i].size() > 3) {
                // 按照分数降序排序
                g[i].sort((a, b) -> b[0] - a[0]);
                // 截取出3个分数最大的顶点,这里一定要new!!!
                g[i] = new ArrayList<>(g[i].subList(0, 3));
            }
            // 若相邻接点个数为<=3,则最大的点肯定在其中
        }
        int res = -1;
        // 遍历每条边
        for (int[] edge : edges) {
            // a——x——y——b中的x与y
            int x = edge[0], y = edge[1];
            // 遍历a
            for (int[] p : g[x]) {
                // 可能的a的最大分数
                int leftScore = p[0];
                for (int[] q : g[y]) {
                    // 可能的b的最大分数
                    int rightScore = q[0];
                    // 维护合法和的最大值
                    if (p[1] != y && p[1] != q[1] && q[1] != x) {
                        res = Math.max(res, leftScore + scores[x] + scores[y] + rightScore);
                    }
                }
            }
        }
        return res;
    }
}