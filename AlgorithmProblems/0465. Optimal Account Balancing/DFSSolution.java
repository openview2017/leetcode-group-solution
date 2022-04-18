/*
https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation) 

hashmap先存
再dfs

array:
-5, 10, -5

*/

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>(); // key: person index; value: dollar amount
        for (int[] t : transactions) {
            int val1 = map.getOrDefault(t[0], 0);
            int val2 = map.getOrDefault(t[1], 0);
            map.put(t[0], val1 - t[2]);
            map.put(t[1], val2 + t[2]);
        }
        
        // 把map里的不为0的value，全部放到list里
        List<Integer> list = new ArrayList<>();
        for (int val : map.values()) { // map.values() api
            if (val != 0) {
                list.add(val);
            }
        }
        
        // 把list转换成array
        int[] debts = new int[list.size()];
        int index = 0;
        for (int i : list) {
            debts[index] = i;
            index++;
        }
        
        // 这里问题转化为，如果是一个array，-5， 10， 5， 多少次能够balance，都变成0？
        // 从index为0的地方出发，要多少次transactions，会变成全部为0？
        return helper(debts, 0);  
    }
    
    // min transactions required, starting from pos position
    private int helper(int[] debts, int pos) {
        while (pos < debts.length && debts[pos] == 0) {
            pos++;
        }
        // corner case，当出界时，前面都是0了，也不需要交易了，所以return 0.
        if (pos == debts.length) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE; // why?? 因为要求最小，所以初始化为max integer
        //long pre = 0;//?
        for (int i = pos + 1; i < debts.length; i++) {
           // if (debts[i] != pre && debts[pos] * debts[i] < 0) {
            if (debts[pos] * debts[i] < 0) {
                debts[i] += debts[pos];//吃
                res = Math.min(res, 1 + helper(debts, pos + 1));
                debts[i] = debts[i] - debts[pos]; // 吐
            }
        }
        return res;
    }    
}
