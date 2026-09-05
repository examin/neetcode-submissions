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

// 0 is left depth;
// 1 is best seen.
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] got = helper(root);
        return Math.max(got[0], got[1])-1;
    }
    private int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left =  helper(root.left);
        int[] right =  helper(root.right);

        int maxDepth = Math.max(left[0], right[0]) + 1;
        int diameterWithThisRoot = left[0] + right[0] + 1;
        int maxSubTreeDiameter = Math.max(left[1], right[1]);
        return new int[]{maxDepth, Math.max(diameterWithThisRoot, maxSubTreeDiameter)};
    }
}
