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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return checkValidity(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidity(TreeNode node, long low, long high){
        if(node == null){
            return true;
        }
        
        if(low < node.val && node.val < high){
            if(checkValidity(node.left, low, node.val)){
                return checkValidity(node.right, node.val, high);
            }
        }
        return false;
    }
}