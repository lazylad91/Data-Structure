/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
public class ListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    
    public static TreeNode toBST(ListNode head, ListNode tail){
            ListNode slow = head;
            ListNode fast = head;
            if(head==tail) return null;    // this mean slow and head was same and as slow val is already used as root so no need to process this now
            while(fast!=tail && fast.next!=tail){         
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode tree = new TreeNode(slow.val);
            tree.left = toBST(head,slow);
            tree.right = toBST(slow.next,tail);
            return tree;
    }
}