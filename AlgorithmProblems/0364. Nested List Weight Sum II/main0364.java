public class main0364 {
    /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

    // 先求每个的高度 然后再求 sum
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        int h = helper(nestedList);
        int res = getSum(nestedList, h);
        return res;
    }
    private int getSum(List<NestedInteger> l, int layer) {
        int sum = 0;
        if(l == null || l.size() == 0) return sum;
        for(NestedInteger n : l) {
            if(n.isInteger()) sum += n.getInteger() * layer;
            else sum += getSum(n.getList(), layer - 1);
        }
        return sum;
    }
    private int helper(List<NestedInteger> l) {
        if(l == null || l.size() == 0) return 0;
        int max = 0;
        for(NestedInteger n : l) {
            if(n.isInteger()) max = Math.max(max, 1);
            else max = Math.max(max, helper(n.getList()) + 1);
        }
        return max;
    }

//1 +    1+4 +    6 + 1+ 4
/*
 [1, [4, [6]]]
1: depth = 1, 
1: height = 3 - 1 + 1 = 3

*/

//TC: O(n) SC: O(n)
}
