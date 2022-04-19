public class main0339 {
   
    
        public int depthSum(List<NestedInteger> nestedList) {
            
            return dfs(nestedList, 1); //深度一开始是1
        }
    
        private int dfs(List<NestedInteger> list, int depth) {
            int total = 0;
            for (NestedInteger nested : list) {
                if (nested.isInteger()) {
                    total += nested.getInteger() * depth;
                } else {
                    total += dfs(nested.getList(), depth + 1);
                }
            }
            return total;
        }
    
    // TC: O(n) SC: O(n)    
    
    // solution 2: 
    /*
    
    int sum = 0; 
    int level = 1;
    
    while (nestedList.size() != 0) {
        List<NestedInteger> temp = new ArrayList<>();
        for (NestedInteger e: nestedList) {
            if (e.isInteger()) {
            sum += e.isInteger() * level;
            } else {
                temp.addAll(e.getList());
            }
        }
        level++;
        nestedList = temp;
    }
    return sum;
    }
    TC: O(n) SC: O(n)
    */
}
