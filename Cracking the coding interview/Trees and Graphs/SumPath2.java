/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * 
 * So what we are doing is - working like same path sum 1
 * but when we are finding the result we are ding the list
 * and in the end we are removing all the elements while backtracking
 * 
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> currentResult = new LinkedList<Integer>();
        findPath(root,result,currentResult,sum);
        return result;
    }
    
    public static void findPath(TreeNode root,List<List<Integer>> result, List<Integer> currentResult,int sum){
        if(root==null)
        return;
        
        currentResult.add(root.val);
        if(sum-root.val==0 && root.left==null && root.right == null){
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size()-1);
            return;
        }
        
        findPath(root.left, result, currentResult, sum-root.val);
        findPath(root.right, result, currentResult, sum-root.val);
        
        currentResult.remove(currentResult.size()-1);
        
    }
}