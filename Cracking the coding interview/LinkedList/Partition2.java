/* So in last solution we used 4 pointers
what if we dont want to use 4 pointers
We can do that by adding all the elements smaller then n by adding to head
and greater by adding to tail */
public class Partition2{
    
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
    
    public static LinkedList doPartition(LinkedList l,int n){
        if(l==null)
        return null;
        
        LinkedList head = l;
        LinkedList tail = l;
        
        while(l!=null){
            LinkedList next = l.next;
            l.next=null;
            if(l.data<n){
             // add element to head
             l.next = head;
             head = l;
            }
            else{
            // add element to tail
                tail.next = l;
                tail = l;
            }
            l=next;
        }
        
        return head;
    }
}