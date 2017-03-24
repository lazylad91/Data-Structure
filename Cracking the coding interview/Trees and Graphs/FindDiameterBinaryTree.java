/*Diameter of a Binary Tree
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
but in this solution we are taking number of edges


The diameter of a tree T is the largest of the following quantities:

* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
* Return max of following three
   1) Diameter of left subtree
   2) Diameter of right subtree
   3) Height of left subtree + height of right subtree + 1 */
*/
public class FindDiameterBinaryTree {
     int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxDepth(root);
        return max;
    }
    
    public  int findMaxDepth(TreeNode root){
        if(root==null)
        return 0;
        
        int leftdepth = findMaxDepth(root.left);
        int rightdepth = findMaxDepth(root.right);
        // this is we are taking number of edges thats leftdepth+rightdepth
        max = Math.max(max, leftdepth+rightdepth);
        // this is actual depth that is number of nodes
        return Math.max(leftdepth,rightdepth)+1;
    }
}