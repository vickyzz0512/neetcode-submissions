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

    // 这里是遍历 root，isSubtree 不比较任何值。 它只负责"走遍 root 的每个节点"，走到一个节点就把这个节点交给 isSameTree 去判断
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // 这里是帮助我们判断 root and subroot 这两棵树长的一不一样
    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean left = isSameTree(a.left , b.left);
        boolean right = isSameTree(a.right, b.right);
        return left && right;
    }

}
