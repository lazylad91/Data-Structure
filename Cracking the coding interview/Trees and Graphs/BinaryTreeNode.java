public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    
    public BinaryTreeNode(int d){
        this.data = d;
    }
    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }
    
    public void setRight(BinaryTreeNode right){
        this.right = right;
    }
    
    public BinaryTreeNode getRight(){
        return this.right;
    }
    
    public BinaryTreeNode getLeft(){
        return this.left;
    }
}