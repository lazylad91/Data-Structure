/**You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]*/

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>(); 
        largestValuesHelper(result,root,0);
        return result;
    }
    
    public void largestValuesHelper(List<Integer> res, TreeNode root,int d){
        if(root==null)
        return;
        
        if(d==res.size()){
            res.add(root.val);
        }
        else{
            res.set(d,Math.max(res.get(d),root.val));
        }
        
        largestValuesHelper(res,root.left,d+1);
        largestValuesHelper(res,root.right,d+1);
    }
    
}