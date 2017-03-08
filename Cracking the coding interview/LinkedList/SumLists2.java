/* Two lists are given in reverse order where each node contain
a single digit, 1's digit is at head and most significant digit
is at tail. Write a function that adds the two number and return
the sum as a linkedlist.
Example -
Input 7-1-6 + 5-9-2 = 617+295= 2-1-9 = 912
Recursive solution
*/
public class SumLists2 {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.data=7;
        LinkedList l1 = new LinkedList();
        l1.data=1;
        LinkedList l2 = new LinkedList();
        l2.data=6;
        
        LinkedList l3 = new LinkedList();
        l3.data=5;
        LinkedList l4 = new LinkedList();
        l4.data=9;
        LinkedList l5 = new LinkedList();
        l5.data=2;

        l.next=l1;
        l1.next =l2;
        l2.next=null;
        
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        
        LinkedList res = addList(l,l3,0);
        
        //Print it
        while(res!=null){
        System.out.println(res.data);
        res=res.next;
        }
    }
    
    public static LinkedList addList(LinkedList l1, LinkedList l2, int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }
    
        int value = carry;
        
        LinkedList result = new LinkedList();
        
        if(l1!=null){
            value += l1.data;
        }
        if(l2!=null){
            value += l2.data;
        }
        result.data=value%10; // Remember Second digit of number
        
        /* Recurse */
        
        if(l1!=null || l2!=null){
        LinkedList more = addList(l1==null ? null : l1.next, l2==null ? null : l2.next, value>=10 ? 1 : 0);    
        result.next = more;
        }
         
         return result;
    }
}