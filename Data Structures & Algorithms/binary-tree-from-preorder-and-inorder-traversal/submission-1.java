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

    int preIdx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        } 
        return helper(preorder, 0, inorder.length - 1);   
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        // 通过在preorder里拿到的root再来inorder里面找，然后分成left subtree and right subtree
        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal);

        root.left = helper(preorder, left, rootIdx - 1);
        root.right = helper(preorder, rootIdx + 1, right);

        return root;
    }
}
