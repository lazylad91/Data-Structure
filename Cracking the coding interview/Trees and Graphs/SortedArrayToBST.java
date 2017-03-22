/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 So mid element is the best one to select root
 after that left will be 0 to mid-1 
 and right will be mid+1 to lenght-1
 so then again 0+mid-1 mid will be root ie root left element and 
 all the elements after new mid till mid-1 will come on right of this root left and 
 from 0 to new mid will come on left
 and as this sorted array, this is perfect bst property
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
        return null;
        
        TreeNode head = makeTree(nums,0,nums.length-1);
        return head;
    }
    
    public TreeNode makeTree(int[] nums, int low, int high){
        if(low>high)
        return null;
        
        int mid = (low+high)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = makeTree(nums,low, mid-1);
        root.right = makeTree(nums,mid+1,high);
        
        return root;
    }
}