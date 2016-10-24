/*http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
Leetcode 143
*/
/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        //http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/ Well explained in this problem
        if(head==null || head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
       
       ListNode second = slow.next;  // Whether list is even or odd we have to move to next element as p1 pointer will be at middle element or last element of first half 
       slow.next = null; // Very important as we wont be going to use it and it will result in memory space exceeded exception
        second = reverseList(second);
    
        // Now we have two list fist and second which is reverse of second half of original list
        ListNode p1 = head;
        ListNode p2 = second;
        while(p2!=null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            // It work as a zig zag but in one loop it will combine 3 elements and will again start from 3rd element
            p1.next = p2;
            p2.next = temp1;
            
            p1=temp1;
            p2=temp2;
            
        }
        
       // return first;
    }
    
    public static ListNode reverseList(ListNode head){
        if(head==null)
        return null;
        ListNode preHead = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = preHead;
            preHead = curr;
            curr = temp;
        }
        return preHead;
    }
}