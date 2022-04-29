/*
TC: O(n)
SC: O(n)
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = getMap(inorder);// value and index for inorder input array
        int n = inorder.length;
        return helper(inMap, 0, n -1, postorder, 0, n - 1);
    }
    private TreeNode helper(Map<Integer, Integer> map, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[postEnd]);
        int mid = map.get(postorder[postEnd]);
        node.left = helper(map, inStart, mid - 1, postorder, postStart, postStart + mid - 1 - inStart);
        node.right = helper(map, mid + 1, inEnd, postorder, postStart + mid - inStart, postEnd - 1);
        return node;      
        
    }
    private Map<Integer, Integer> getMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        return map;
    }
}