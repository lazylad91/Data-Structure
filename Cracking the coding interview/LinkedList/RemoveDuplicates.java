/*This takes extra memory
if u want to do this in O(1)
Then maintain 2 pointers
current and runner and for each current element compare it with all the next element in runner
It will be done in o(n2) which is not good*/
import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.data=1;
        LinkedList l1 = new LinkedList();
        l1.data=1;
        LinkedList l2 = new LinkedList();
        l2.data=2;
        LinkedList l3 = new LinkedList();
        l3.data=3;
        LinkedList l4 = new LinkedList();
        l4.data=3;
        LinkedList l5 = new LinkedList();
        l5.data=3;
        LinkedList l6 = new LinkedList();
        l6.data=5;
        l.next=l1;
        l1.next =l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l  = RemDup(l);
        while(l!=null){
        System.out.println(l.data);
        l=l.next;
        }
    }
    public static LinkedList RemDup(LinkedList l){
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList previous = null;
        LinkedList head = l;
        while(l!=null){
            if(set.contains(l.data)){
               previous.next = l.next;
            }
            else{
                set.add(l.data);
                previous = l;
            }
            l = l.next;
        }
        return head;
    }
}