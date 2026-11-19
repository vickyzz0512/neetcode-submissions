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

        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            // 记录每一层的个数
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 取出node并且把node的val加入level
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    // 把孩子加入queue
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 处理完当前层，把当前层的level加入到result
            result.add(level);
        }
        return result;        
    }
}
