public class FindCycle {
    public static void main(String[] args){
          LinkedList l = new LinkedList();
        l.data=1;
        LinkedList l1 = new LinkedList();
        l1.data=2;
        LinkedList l2 = new LinkedList();
        l2.data=3;
        LinkedList l3 = new LinkedList();
        l3.data=4;
        LinkedList l4 = new LinkedList();
        l4.data=5;
        LinkedList l5 = new LinkedList();
        l5.data=6;
        LinkedList l6 = new LinkedList();
        l6.data=7;
        l.next=l1;
        l1.next =l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next = l3;
        
         l = findCycleAndReturnHead(l);
         
        System.out.println(l.data);

    }
    
    public static LinkedList findCycleAndReturnHead(LinkedList l1){
        LinkedList slow = l1;
        LinkedList fast = l1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            break;
        }
        
        if(fast == null || fast.next == null){
            return null;
        }
        slow = l1;
        
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
}