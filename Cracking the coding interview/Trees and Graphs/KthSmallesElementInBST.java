/** Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST). */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Solution is to use in order traversal and u know -inorder traversal of BST is sorted array.
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
        return 0;
        int i=0;
        int res=0;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(true){
            
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            
            if(st.isEmpty())
            break;
            
            root = st.pop();
            i++;
            if(i==k){
                res = root.val;
                break;
            }
            root = root.right;
            
        }
        
        return res;
    }
}