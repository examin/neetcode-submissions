/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }
    private void dfsSerialize(TreeNode root, List<String> res){
        if(root==null){
            res.add("N");
        }else{
            res.add(String.valueOf(root.val));
            dfsSerialize(root.left, res);
            dfsSerialize(root.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        return dfsDeserialize( input, new int[]{0});
    }
    private TreeNode dfsDeserialize( String[] input, int[] index){
        int[] i = index;
        if(index[0]>input.length|| input[index[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = Integer.valueOf(input[i[0]]);
        i[0]++;
        root.left = dfsDeserialize( input, i);
        root.right = dfsDeserialize( input, i);
        return root;
    }
}
