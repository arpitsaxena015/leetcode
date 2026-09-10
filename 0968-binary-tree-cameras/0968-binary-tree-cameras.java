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
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        // If the root itself needs a camera, we add one at the root
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    // 0: Needs a camera
    // 1: Has a camera
    // 2: Covered
    private int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If either child needs a camera, we MUST place a camera at the current node
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // If either child has a camera, the current node is already covered
        if (left == 1 || right == 1) {
            return 2;
        }

        // If both children are covered but neither has a camera, 
        // the current node is not covered and will need its parent to have a camera
        return 0;
    }
}