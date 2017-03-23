/**
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

so when u exchange the left and right of root
the whole sub tree get exchanged
so u just have to do it recursively
Better way is to do with stack - 


  public TreeNode invertTree(TreeNode root) {
       if(root==null)
        return null;
        
       LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
       
       while(!queue.isEmpty()){
           TreeNode node = queue.poll();
           TreeNode left = node.left;
           node.left = node.right;
           node.right = left;
           
           if(node.left!=null)
           queue.offer(node.left);
           
           if(node.right!=null)
           queue.offer(node.right);
           
           
       }
       
       return root;
       
       
       
**/
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
        return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
}