/*The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)

Hope this helps.*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int inStart,int preStart,int inEnd, int[] preorder, int[] inorder){
        if(inStart>inEnd || preStart> preorder.length-1)
        return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        //Lets find this in in order where it is
        int inIndex = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val)
                inIndex =i;
        }
        // preStart(Right) = preStart+inIndex-instart+1 as we are just moving the elements
        root.left = helper(inStart, preStart+1, inIndex-1, preorder, inorder);
        root.right = helper(inIndex+1,preStart+inIndex-inStart+1,inEnd, preorder,inorder );
        
        return root;
    }
}