/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteNthElement {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        // We are appending a node with value 0 so that we can handle the case with only 1 element, otherwise if we start with head only
        // then curr and follower will be at 1 only there wont be a gap.
        ListNode result= new ListNode(0);
        result.next = head;
        ListNode curr = result;
        ListNode follower = result;
        for(int i=0; i<n; i++){
            if(curr == null) return null;
            curr = curr.next;
        }
       // Testing curr.next to stop curr at last element as if next is null then that node is last element
        while(curr.next!=null){
            curr=curr.next;
            follower=follower.next;
        }
        // we will go till one element before the element we have to delete
        // Example - 1-2-3-4-5-6 if n=3 means we have to delete 4 so we will got till 3(which is follower)
        follower.next = follower.next.next;
        return result.next;
        }
}