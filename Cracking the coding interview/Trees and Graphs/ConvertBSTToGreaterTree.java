/**Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
Subscribe to see which companies asked this question.*/

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
    public TreeNode convertBST(TreeNode root) {
     int prevSum = 0;
     Stack<TreeNode> st = new Stack<TreeNode>();
     TreeNode head = root;
     while(true){
         while(root!=null){
             st.push(root);
             root=root.right;
         }
         
         if(st.isEmpty())
         break;
         
         TreeNode node = st.pop();
         node.val = node.val+prevSum;
         prevSum = node.val;
         root = node.left;
     }
     
     return head;
    }
}