public class main0297 {
    
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static String SEP = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb = dserialize(root, sb);
        return sb.toString(); 
    }
    
    private StringBuilder dserialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null" + SEP);
            return sb;
        } 
        sb.append(root.val + SEP);
        sb = dserialize(root.left, sb);        
        sb = dserialize(root.right, sb);            
        return sb;        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        List<String> datalist = new LinkedList<>(Arrays.asList(dataArr));
        return rdeserialize(datalist);
    }
    
    private TreeNode rdeserialize(List<String> datalist) {
        if (datalist.get(0).equals("null")) {
            datalist.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(datalist.get(0)));
        datalist.remove(0);
        root.left = rdeserialize(datalist);        
        root.right = rdeserialize(datalist);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));