/*You are given two linked lists representing two non-negative numbers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);  
            l2=l2.next;
        }
        int sum = 0;
        ListNode res = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            res.val = sum%10;                               // This value will contain carry and now will be updated by sum of 2 digits and carry from previous addition
            ListNode head = new ListNode(sum/10);
            head.next = res;                                // This is making a new head and attaching old list to new head so that least signification digit will come at last node
            res = head;                                         
            sum /= 10;  //carry forward             
        }
        return res.val==0 ? res.next : res;                 // If carry from last addition is 0 we wont need to return that so for that its res.next
    }
}