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
        return traversal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean traversal(TreeNode root, Long min, Long max){
        if(root == null){
            return true;
        }
        // System.out.println((long)root.val);
        if(min >= (long)root.val || max <= (long)root.val){
            return false;
        }
        return traversal(root.left, min, (long)root.val) && traversal(root.right, (long) root.val, max);
    }
}