/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortListInsertion {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next = null;
        while(cur!=null){
        next = cur.next;    
        while(pre.next!=null && pre.next.val<=cur.val){
                pre = pre.next;
            }
        //insert between pre and pre.next
        cur.next = pre.next;
        pre.next = cur;
        cur = next;
        pre = heper;
    }
    return helper.next;
    }
}