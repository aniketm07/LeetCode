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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int n = queue.size();
                List<Integer> list = new ArrayList<>();
                while(n-- > 0){
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}