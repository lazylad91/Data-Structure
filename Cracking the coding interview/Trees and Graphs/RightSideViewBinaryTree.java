/**Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].*/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res,root,0);
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode root, int level){
        if(root==null)
        return;
        
        if(res.size()==level){
            res.add(root.val);
        }
        
        if(root.right!=null)
        helper(res,root.right,level+1);
        
        if(root.left!=null)
        helper(res,root.left,level+1);
    }
}