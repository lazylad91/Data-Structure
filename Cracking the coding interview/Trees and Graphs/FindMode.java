/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


Trick is we are setting prev to left and then matching root and then prev to root and then matching right using in order traversal

 */
public class Solution {
    
    Integer prev;
    int max = 0;
    int count = 1;
    public int[] findMode(TreeNode root) {
        if(root==null)
        return new int[0];
        
        List<Integer> list = new ArrayList<Integer>();
        traverseTree(root,list);
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public void traverseTree(TreeNode root, List<Integer> list){
        if(root==null)
        return;
        
        traverseTree(root.left,list);
        
        if(prev!=null){
            if(prev==root.val){
                count++;
            }
            else{
                count=1;
            }
        }
        
        if(count>max){
            max=count;
            list.clear();
            list.add(root.val);
        }
        else if(count==max){
            list.add(root.val);
        }
        
        prev = root.val;
        traverseTree(root.right,list);
    }
}