/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   
   So solution is we have to divide the array 
   like we can take root value any number in the array
   as binary tree 1 to n is inorder of it like 1 2 3 4 5 6 7 8
   so we can take root 1 or 2 or 3 or 4 or 5 or 6 
   so whatever we take root - elements before root are left tree and elements after root is right tree
   now those left and right tree also can have multile representation
   so we will generate them recursively
   for each root we will be having list of left tree and list of right tree
   so for each tree in left tree we can have each combination from the right tree with root as selected value.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
        return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }
    
    public List<TreeNode> generateTrees(int start, int end){
         List<TreeNode> trees = new ArrayList<TreeNode>();
        
        if(start>end) {
        trees.add(null); 
        return trees;
        }
        
        for(int rootValue = start; rootValue<=end; rootValue++){
            List<TreeNode> leftTreeList = generateTrees(start,rootValue-1);
            List<TreeNode> rightTreeList = generateTrees(rootValue+1,end);
            
            for(TreeNode leftSide : leftTreeList){
                for(TreeNode rightSide : rightTreeList){
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftSide;
                    root.right = rightSide;
                    trees.add(root);
                }
            }
        }
        
        return trees;
        
    }
}