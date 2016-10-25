/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 http://www.programcreek.com/2014/06/leetcode-reverse-linked-list-ii-java/*/

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null)
        return head;
        
        if(m==n)
        return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // Suppose list is 1-2-3-4-5-6 and m=2 and n =4
        for(int i=0; i<m-1; i++){
            prev= prev.next;         // Pointer to element one before the mth element  i.e 1
        }
        
        ListNode start = prev.next;   // Pointer to mth element         i.e 2
        ListNode then = start.next;   // Pointer to m+1th element       i.e 3
        // m-n will tell what numbers to be reversed
        for(int i=0; i<n-m ; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}