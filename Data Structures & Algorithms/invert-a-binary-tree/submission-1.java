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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 把left subtree and right subtree 翻转好
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 然后把翻转好的left subtree and right subtree 再挂回去
        root.left = right;
        root.right = left;
   
        return root;
    }
}
