/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Subscribe to see which companies asked this question.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /*
 So first solution is write a function to max depth of tree
 then find depth of left sub tree n right if diff(>1 ) then return false
 else isBalanced(leftree) && isBalanced(rightre
 e)
 It will take n square 
 so lets do it the right way which is we will start from the end
 and find whether the last subtree is balanced and make our way up
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
       return dfsHeight(root) != -1;
    }
    
    public int dfsHeight(TreeNode root){
        
        if(root==null)
        return 0;
        
        int leftHeight = dfsHeight(root.left);
        if(leftHeight==-1) return -1;
        
        int rightHeight = dfsHeight(root.right);
        if(rightHeight==-1) return -1;
        
        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        else return Math.max(leftHeight,rightHeight)+1;
    }
}