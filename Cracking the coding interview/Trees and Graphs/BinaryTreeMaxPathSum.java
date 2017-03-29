/**Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
     
Its equivalent to diameter only, instead of nodes we have to count the sume     
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
     maxValue = Integer.MIN_VALUE;
     maxPathSumHelper(root);
     return maxValue;
    }
    
    public int maxPathSumHelper(TreeNode root){
        if(root==null)
        return 0;
        
        // Math.max with 0 is coz of negative sum
        // in that case we have to avoid left
        int left = Math.max(0,maxPathSumHelper(root.left));
      
        int right = Math.max(0,maxPathSumHelper(root.right));
     
        maxValue = Math.max(maxValue,left+right+root.val);
       
        return Math.max(left,right) + root.val;
    }
}