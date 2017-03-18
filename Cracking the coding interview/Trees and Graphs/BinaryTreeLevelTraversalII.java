/*

Leetcode - 107

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        makeList(list,root,0);
        Collections.reverse(list);
        return list;
    }
    
    public static List<List<Integer>> makeList(List<List<Integer>> list, TreeNode root, int lvl){
        
        if(root==null)
        return list;
        
        List<Integer> lst=null;
        if(list.size()==lvl){
            lst = new ArrayList<Integer>();
            list.add(lst);
        }
        
        lst = list.get(lvl);
        lst.add(root.val);
        
        makeList(list, root.left, lvl+1);
        makeList(list, root.right, lvl+1);
        
        return list;
    }
}