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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        traverseLeft(root.left, ans);
        System.out.println(Arrays.toString(ans.toArray()));
        traverseLeaf(root.left, ans);
        traverseLeaf(root.right, ans);
        System.out.println(Arrays.toString(ans.toArray()));
        Stack<Integer> stack = new Stack<>();
        traverseRight(root.right, stack);
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
    }

    public void traverseRight(TreeNode node, Stack<Integer> stack){
        if(node == null) return;
        if(node.right == null){
            if(node.left == null){
                return;
            }else{
                stack.push(node.val);
                traverseRight(node.left, stack);
            }
        }else{
            stack.push(node.val);
            traverseRight(node.right, stack);
        }
    }

    public void traverseLeft(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(node.left == null){
            if(node.right == null){
                return;
            }else{
                ans.add(node.val);
                traverseLeft(node.right, ans);
            }
        }else{
            ans.add(node.val);
            traverseLeft(node.left, ans);
        }
    }

    public void traverseLeaf(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            ans.add(node.val);
            return;
        }
        if(node.left != null) traverseLeaf(node.left, ans);
        if(node.right != null) traverseLeaf(node.right, ans);
    }
}