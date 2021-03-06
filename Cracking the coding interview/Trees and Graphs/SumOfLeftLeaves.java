/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Recursive solution 
 *        /* int ans=0;
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null)
                ans= ans + root.left.val;
            else
            ans = ans + sumOfLeftLeaves(root.left);
        }
        
        if(root.right!=null){
            ans = ans + sumOfLeftLeaves(root.right);
        }*/
 */
public class SumOfLeftLeaves{
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        return 0;
        
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.addFirst(root);
        TreeNode temp=null;
        int ans=0;
         while(!que.isEmpty())
        {
            temp = que.pollFirst();
            
            if(temp.left!=null){
            if(temp.left.left==null && temp.left.right==null)
            ans += temp.left.val;
            else   // As if its a leaf node, we dont need to process it, so dont put it in the queue
            que.addLast(temp.left);
            }
            if(temp.right!=null)
            que.addLast(temp.right);
        }
        
        return ans;
    }
}