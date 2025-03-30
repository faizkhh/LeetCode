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
     public int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int good = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);

        good += countGoodNodes(node.left, maxVal);
        good += countGoodNodes(node.right, maxVal);

        return good;
    }

    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    
        
    }
}