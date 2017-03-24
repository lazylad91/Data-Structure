/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode current;
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
         current = root;
         st = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty() || current!=null ;
    }

    /** @return the next smallest number */
    public int next() {
        while(current!=null)
        {
            st.push(current);
            current = current.left;
        }
        
        TreeNode node = st.pop();
        current = node.right;
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */