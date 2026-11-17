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
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);   
    }
    // 用 helper 把 parent 的值往下传，给每个 node 一个允许的范围 (min, max)
    private boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }
}
