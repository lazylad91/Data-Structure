/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     return helper(0,inorder.length-1,0,postorder.length-1,inorder,postorder);
    }
    
    public TreeNode helper(int instart, int inend, int posstart, int posend, int[] inorder, int[] postorder){
        if(instart>inend || posstart > posend)
        return null;
        
        TreeNode root = new TreeNode(postorder[posend]);
        int inRootIndex = 0;
        for(int i=0; i<=inend; i++){
            if(inorder[i] == postorder[posend]){
              inRootIndex = i;
              break;
            }
        }
        
        root.left = helper(instart,inRootIndex-1,posstart,posstart+inRootIndex-instart-1,inorder,postorder);
        root.right = helper(inRootIndex+1, inend, posstart+inRootIndex-instart, posend-1,inorder,postorder);
        return root;
    }
}