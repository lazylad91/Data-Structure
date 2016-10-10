/*Given a singly linked list, determine if it is a palindrome.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode curr=head;   // This will move 1 node
        ListNode runner=head;   // This will move 2 nodes 
        // When runner reached end of list or null means list is even or odd 
        //and current will be at middle or start of other half of list
        Stack<Integer> stk = new Stack<Integer>(); // To save the first half of list for comparison
        while(runner!=null && runner.next!=null){
            stk.push(curr.val);
            curr = curr.next;
            runner = runner.next.next;
        }
        // So its even no need to drop anything otherwise perform this
        // If its even runner = last element of list
        // It its odd runner == null
        if(runner!=null) 
            curr = curr.next;
            
        while(curr!=null){
            if(stk.pop().intValue()!=curr.val) return false;
            curr = curr.next;
        }
        return true;
    }
}