/*Contributors: Admin
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/

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
    public int minDepth(TreeNode root) {
        if(root==null)
        return 0;
        
        int left=0,right=0;
        
        left= minDepth(root.left);
        right = minDepth(root.right);
        
        // we are adding 1 in the end this left=0 or right=0 will handle 2 cases 
        // 1st is if root is leave node then return 1
        // or if either of one is zero indicates root doesnt have left or right child so, its min depth is 0+depth of child+1
        // third if both have some depth then return min+1
        return (left==0 || right==0) ? left+right+1 : Math.min(left,right)+1;
    
    }
    
    
}