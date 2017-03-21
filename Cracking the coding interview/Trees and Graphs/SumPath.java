/* 
There are 2 ways to do this problem 

1 - Recursively
    Top down approach
    1) check root.val-sum == 0 and root doesnt have left and right child return true
    2) if root.left!=null call sameFUnc(root.left,sum-root.data) and same with right tree
    
     public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.val-sum==0 && root.left==null && root.right==null)
            return true;
            
        return hasPathSum(root.left, sum-root.val)|| hasPathSum(root.right,sum-root.val);
        
        return false;
    }
    
    

2 - Non recursive
    We have to iterate the tree and we have to reach till all leaves
    While pushing node to stack add its value to sum
    so once we reach left end of tree - then we can check sum and calculated sum
    if not equal - then lets backtrack 
    So problem with backtracking is if get to the node with child , we can put right child again and get into infinite loop
    We dnt have to deal with left as while pushing we handled all left child for each element in stack.
    So first we will get the top element - we will see if it has right child, if it has then we will match with previous element
    popped in stack, if they are not equal then that means we didnt process right element yet so we can set curr to right child
    else we are done both ways from current node so set current to null, for moving on to next element in stack and also update previous to
    curr, its important.
*/
import java.util.*;

public class SumPath {
    public static void main(String[] args){
                BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        
        node1.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node1.setRight(node3);
        node3.setLeft(node6);
        node3.setRight(node7);
        
        System.out.println(hasPath(node1,-1));
    }
    
    public static boolean hasPath(BinaryTreeNode root,int sum){
        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        if(root==null && sum==0)
        return true;
        
        if(root.left==null && root.right==null && root.data == sum){
            return true;
        }
        
        int calsum = 0;
        BinaryTreeNode pre = null;
        BinaryTreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            
            while (curr!=null) {
                calsum += curr.data;
                st.push(curr);
                curr=curr.left;
            }
            
            curr = st.peek();
            
            if(curr.right==null && curr.left==null && sum == calsum)
            return true;
            
            if (curr.right!=null && pre != curr.right) {
                curr = curr.right;
            } else {
                pre = curr;
                st.pop();
                calsum -= curr.data;
                curr = null;
            }
        }
        
        return false;
    }
}