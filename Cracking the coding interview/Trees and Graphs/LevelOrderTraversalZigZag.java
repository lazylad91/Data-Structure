/** Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
        return res;
        helper(res, root, 0);
        return res;
    } 
    
    public void helper(List<List<Integer>> res, TreeNode root, int level){
        if(root==null)
        return;
        List<Integer> list;
        
        if(res.size()==level){
            list = new ArrayList<Integer>();
            res.add(list);
        }
        else
        list = res.get(level);
        
        if(level%2==0)
        list.add(root.val);
        else
        list.add(0,root.val);
        helper(res,root.left,level+1);
        helper(res,root.right,level+1);
    }
    
    
}