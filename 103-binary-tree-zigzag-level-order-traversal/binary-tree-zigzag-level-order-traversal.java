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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(isLeft){
                int n = queue.size();
                for(int i=0; i<n; i++){
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                    list.add(node.val);
                }
                ans.add(list);
                isLeft = false;
            }else{
                Stack<TreeNode> stack = new Stack<>();
                int n = queue.size();
                //[20]
                //node = 9
                // stack [9, ]
                for(int i=0; i<n; i++){
                    TreeNode node = queue.poll();
                    stack.push(node);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                while(!stack.isEmpty()){
                    TreeNode node = stack.pop();
                    list.add(node.val);
                }
                ans.add(list);
                isLeft = true;
            }
        }
        return ans;
    }
}