/** Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Gist is do level order traversal but in normal level order traversal right most element
 * comes last, here will gonna process right first so that left most element comes last in queue
 */
public class Solution {
    
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
          root = queue.poll();
          
          if(root.right!=null)
          queue.offer(root.right);
          
          if(root.left!=null)
          queue.offer(root.left);
        }
        
        return root.val;
    }
    
}
