/** Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   
 **/
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Logic is left.left == right.right && left.right = right.left
 * then   left.left.left = right.right.right && left.left.right = right.right.left && left.right.right = right.left.right && left.right.right = right.left.left
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return true;
        return isSymetricHelper(root.left,root.right);
    }
    
    public boolean isSymetricHelper(TreeNode left, TreeNode right){
        if(left==null || right==null)
        return left==right;
        
        if(left.val==right.val)
        return isSymetricHelper(left.left,right.right) && isSymetricHelper(left.right,right.left);
        
        return false;
    }
}