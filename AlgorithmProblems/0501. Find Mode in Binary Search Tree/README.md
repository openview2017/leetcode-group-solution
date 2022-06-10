



















*Tang Zhao*

```java
class Solution0501 {
    
    private int preVal;
    private int maxFreqTree;
    private int maxCount = 0;
    private int count = 0;  
    
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preVal = root.val;
        inorder(root, res);
        int[] rst = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rst[i] = res.get(i);
        }
        return rst;
    }
    
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        
        // process
        process(root, res);

        
        inorder(root.right, res);
    }
    
    private void process(TreeNode root, List<Integer> res) {
        if (root.val != preVal) {
            count = 1;
        } else {
            count++;
        }           
        
        if (count > maxCount) {
            maxCount = count;
            maxFreqTree = root.val;
            res.clear();
            res.add(root.val);
        } else if (count == maxCount && root.val != maxFreqTree) {
            res.add(root.val);
        }
        preVal = root.val;        
    }
}
```

