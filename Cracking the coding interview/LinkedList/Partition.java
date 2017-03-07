/* Question is to partition the list among one element-n, 
Such that all elements less then n should come before elements greater than or equal to n.
if n is contained in the list it can be anywhere in right side. It does not need to appear between
left or right partion
In first solution- We will use 4 pointers to divide it
*/
public class Partition {
    public static void main(String[] args){
        
        // Create Input list
         LinkedList l = new LinkedList();
        l.data=3;
        LinkedList l1 = new LinkedList();
        l1.data=5;
        LinkedList l2 = new LinkedList();
        l2.data=8;
        LinkedList l3 = new LinkedList();
        l3.data=5;
        LinkedList l4 = new LinkedList();
        l4.data=10;
        LinkedList l5 = new LinkedList();
        l5.data=2;
        LinkedList l6 = new LinkedList();
        l6.data=1;
        l.next=l1;
        l1.next =l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        
        // Call the logic
        l=doPartition(l,5);
        
        //Print it
        while(l!=null){
        System.out.println(l.data);
        l=l.next;
        }
        
    }
    
    public static LinkedList doPartition(LinkedList node,int n){
        LinkedList beforeStart = null;
        LinkedList beforeEnd = null;
        LinkedList afterStart = null;
        LinkedList afterEnd = null;
        while(node!=null){
        LinkedList next = node.next;
        node.next=null;
        if(node.data<n){
                if(beforeStart==null){
                    beforeStart=node;
                    beforeEnd = node;
                }
                else{
                    beforeEnd.next = node;
                    beforeEnd=node;
                }
            }
        
        else{
                if(afterStart==null){
                    afterStart=node;
                    afterEnd=node;
                }
                else{
                    afterEnd.next=node;
                    afterEnd=node;
                }
            }
            node = next;
        }
        
        if(beforeStart==null)
            return afterStart;
        else{
            beforeEnd.next=afterStart;
            return beforeStart;
        }
        
    }
}