/*
similar to 543. Diameter of Binary Tree

在所有的children里面，找出第一大和第二大的。
*/

class Solution {
    public int diameter(Node root) {
        // corner case check
        if (root == null) {
            return 0;
        }
        
        int[] diameter = new int[1];
        helper(root, diameter);
        return diameter[0];
    }
    // return the longest single side, including the root
    private int helper(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int longest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (Node child : root.children) {
            int curLength = helper(child, diameter);
            if (curLength > longest) {
                second = longest;
                longest = curLength;
            } else if (curLength > second) {
                second = curLength;
            } 
        }
        diameter[0] = Math.max(diameter[0], longest + second);
        return longest + 1;
    }
}