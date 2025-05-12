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
        List<List<Integer>> result = new ArrayList<>();
        dfsLevelOrder(root, 0 , result);
        return result;
    }

    private void dfsLevelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        dfsLevelOrder(node.left, level + 1, result);
        dfsLevelOrder(node.right, level + 1, result);
    }
}