/* Two lists are given in reverse order where each node contain
a single digit, 1's digit is at head and most significant digit
is at tail. Write a function that adds the two number and return
the sum as a linkedlist.
Example -
Input 7-1-6 + 5-9-2 = 617+295= 2-1-9 = 912
*/

public class SumLists {
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
        
        LinkedList res = sum(l,l3);
        
        //Print it
        while(res!=null){
        System.out.println(res.data);
        res=res.next;
        }
        
    }
    
    public static LinkedList sum(LinkedList l1, LinkedList l2){
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        
        LinkedList res=null;
        LinkedList head=null;
        int carry=0;
        while(l1!=null||l2!=null){
            int a=0;
            int b=0;
            if(l1!=null)
            a=l1.data;
            if(l2!=null)
            b=l2.data;
            int sum = a+b+carry;
            System.out.println(sum);
            carry=0;
            LinkedList n =new LinkedList();
            n.data=sum%10;
            if(res==null)
            {
                res=n;
                head=n;
            }
            else{
            res.next=n;
            res=n;
            }
            carry=sum/10;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
            
        }
        if(carry!=0){
        LinkedList carryNode = new LinkedList();
        carryNode.data=carry;
        res.next=carryNode;
        }
        
        return head;
    }
}