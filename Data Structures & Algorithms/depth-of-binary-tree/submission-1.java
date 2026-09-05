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

class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> nodeAndLevelStack = new Stack<>();
        if(root==null){
            return 0;
        }
        int result = 0;
        nodeAndLevelStack.push(new Pair<>(root, 1));
        while(nodeAndLevelStack.size()>0){
            Pair<TreeNode, Integer> curr = nodeAndLevelStack.pop();
            TreeNode currNode = curr.getKey();
            int depth = curr.getValue();

            if(currNode.left!=null){
                nodeAndLevelStack.push(new Pair<>(currNode.left, depth+1)) ;
            }
            if(currNode.right!=null){
                nodeAndLevelStack.push(new Pair<>(currNode.right, depth+1));
            }
            result = Math.max(result, depth);
        }
        return result;
    }
}
