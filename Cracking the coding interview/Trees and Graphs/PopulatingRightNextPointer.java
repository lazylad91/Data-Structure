/**Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).*/



/**public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}*/


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * 
 * Below solution can also find height of tree as it can count the level.
 * It is inserting null before every level start
 * The solution above in comment mode
 * It is working on that take root as current node
 * then if current has left child so current left child next will current right child (if present otherwise set to null)
 * then current right child next can be current next left child
 * then we will set current = current.next
 * We will move till current!=null
 * after that we will set levelstart to levelstart.left
 * 
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
        return;
        
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode prev = null;
        while(!queue.isEmpty()){
            root = queue.poll();
            
            //new level
            if(root==null){
                if(prev!=null){
                prev.next = null;
                System.out.println(prev.val);
                }
                // Have to end
                if(!queue.isEmpty())
                queue.offer(null);
                prev=null;
            }
            else {
                if(prev!=null)
                prev.next = root;
                prev = root;
                if(root.left!=null)
                queue.offer(root.left);
                if(root.right!=null)
                queue.offer(root.right);
            }
        }
    }
}