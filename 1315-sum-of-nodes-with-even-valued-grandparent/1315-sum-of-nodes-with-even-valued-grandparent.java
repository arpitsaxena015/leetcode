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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        // If grandparent exists and has an even value, add this node's value
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += node.val;
        }

        // Recursively check left and right subtrees, passing updated parent and grandparent references
        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);

        return sum;
    }
}