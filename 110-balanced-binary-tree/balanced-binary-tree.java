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

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1; 
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }

        int left  = getHeight(root.left);
        int right = getHeight(root.right);

        if(Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }

        return false;
    }
}