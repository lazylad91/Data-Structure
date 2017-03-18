/* 
For non iterative solution - its same as level order traversal - just instead of finding max search that element
*/
public class SearchElementBinaryTree {
        public static void main(String[] args){
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        
        node1.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node1.setRight(node3);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
        node5.setLeft(node10);
        node5.setRight(node11);
        
        
        System.out.println(search(node1,8).data);
    }
    
    public static BinaryTreeNode search(BinaryTreeNode root, int data){
        if(root==null)
        return null;
        
        if(root.data == data)
        return root;
        
        BinaryTreeNode left=null;
        BinaryTreeNode right=null;
        
        if(root.getLeft()!=null)
        left = search(root.getLeft(), data);
    
        if(root.getRight()!=null)
        right = search(root.getRight() , data);
        
        return left!=null ? left : right;
    } 
}