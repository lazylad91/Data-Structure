/* 
    Recursive way to find max in binary tree
    for non recursive way do level order traversal and maintain max
    
*/

import java.util.*;

public class FindMaxBinaryTree {
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
        
        System.out.println(findMax(node1));
        System.out.println(findMaxNonRecursive(node1));
    }
    
    public static int findMax(BinaryTreeNode root){
        int root_val, left, right, max = Integer.MIN_VALUE;
     
     if(root!=null){
         root_val = root.data;
         
         left = findMax(root.getLeft());
         right = findMax(root.getRight());
         
         max = right>left ? right : left;
         
         max = max>root_val ? max : root_val;
     }
     return max;   
    }
    
    public static int findMaxNonRecursive(BinaryTreeNode root){
        int max = Integer.MIN_VALUE;
        
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        
        queue.addFirst(root);
        
        while(!queue.isEmpty()){
            BinaryTreeNode temp = queue.pollFirst();
            if(temp.data>max)
                max=temp.data;
            if(temp.getLeft()!=null)
                queue.addLast(temp.getLeft());
            if(temp.getRight()!=null)
                queue.addLast(temp.getRight());
        }
        
        return max;
    }
}