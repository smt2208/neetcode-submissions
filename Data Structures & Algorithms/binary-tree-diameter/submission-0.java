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
    int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
            // Call DFS to calculate height of the root.
            // During the traversal, maxDiameter will be updated.
            height(root);
            return maxDiameter;
            
        }
        public int height(TreeNode node)
        {
            if (node == null) {
            return 0; // Height of an empty tree is 0
        }

        // Recursively get the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Calculate the diameter passing through the current node.
        // The path goes from the deepest node in the left subtree,
        // up to the current node, and down to the deepest node in the right subtree.
        // The number of edges is leftHeight + rightHeight.
        int currentDiameter = leftHeight + rightHeight;

        // Update the global maximum diameter if the current one is larger
        // Note: We use Math.max because the longest path might be in a subtree, not passing through the current root.
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Return the height of this node for the parent to use
        // Height = max(left, right) + 1 (the +1 is for the edge to the parent)
        return Math.max(leftHeight, rightHeight) + 1;
    }

}

