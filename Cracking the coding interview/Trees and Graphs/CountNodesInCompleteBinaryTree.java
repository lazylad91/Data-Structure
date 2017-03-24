/**
 * 
 * Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        // If height of the tree is zero then zero nodes
        if(h==-1)
        return 0;
        // Now we will find the height of right tree - 
        // if height of right subtree is 1 less then
        // height of tree, then means left height and right subtree has some height
        // so left tree is actually have all the nodes which is equal to 2^h and 1 for root node + countNodes(root.right)
        // else right subtree is fully completed and extra nodes are in left so result = 2^h-1 + countNodes(root.left)
        return (h-1==height(root.right)) ? (1<<h) + countNodes(root.right) :
                                           (1<<h-1) + countNodes(root.left);
    }
    
    public int height(TreeNode root){
        if(root==null) return -1;
        // Its a complete binary tree
        //so we can get height of the tree by just
        //calculating the height of left tree
        return 1+height(root.left);
    }
}