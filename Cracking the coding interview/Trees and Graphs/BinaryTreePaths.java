/*Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question.
*/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null)
        return res;
        binaryTreeHelper("", root, res);
         return res;
    }
    
    public void binaryTreeHelper(String path, TreeNode root, List<String> res){
        path = path + root.val;
        if(root.left==null && root.right==null)
        {
            res.add(path);
            return;
        }
        if(root.left!=null){
            binaryTreeHelper(path+"->", root.left, res);
        }
        
        if(root.right!=null){
            binaryTreeHelper(path+"->", root.right, res);
        }
    }
}