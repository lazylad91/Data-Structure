import java.util.*;

public class LevelOrderTraversal {
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
        
        levelOrder(node1);
    }
    
    public static void levelOrder(BinaryTreeNode node)
    {
        LinkedList<BinaryTreeNode> que = new LinkedList<BinaryTreeNode>();
        que.addFirst(node);
        
        BinaryTreeNode temp;
        
        if(node == null)
        return;
        
        while(!que.isEmpty())
        {
            temp = que.pollFirst();
            System.out.println(temp.data);
            
            if(temp.getLeft()!=null)
            que.addLast(temp.getLeft());
            
            if(temp.getRight()!=null)
            que.addLast(temp.getRight());
        }
        
        return;
    }
}