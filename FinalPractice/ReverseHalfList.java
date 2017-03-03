
public class ReverseHalfList {
    public static LNode reverseLinkedList(LNode list) {
        if(list==null || list.next==null)
        return list;
        
        // Code for finding length of the list
        LNode slow = list;
        int length = 0;
        int mid = 0;
        while(slow!=null){
            slow = slow.next;
            length++;
        }
        if(mid%2==0)
        mid = length/2;
        else
        mid = (length+1)/2;
        
        LNode dummy = new LNode();
        dummy.value=0;
        dummy.next = list;
        LNode prev = dummy;
        // Suppose list is 1-2-3-4-5-6 and m=2 and n =4
        for(int i=0; i<mid; i++){
            prev= prev.next;         // Pointer to element one before the mth element  i.e 1
        }
        
        LNode start = prev.next;   // Pointer to mid element         i.e 2
        LNode then = start.next;   // Pointer to mid+1 element       i.e 3
        System.out.println(start.value);
        System.out.println(then.value);
        // m-n will tell what numbers to be reversed
        for(int i=0; i<length-mid-1 ; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
    public static void main(String args[]){
        LNode list = new LNode();
        list.value=1;
        LNode list2 = new LNode();
        list2.value=2;
        list.next = list2;
        LNode list3 = new LNode();
        list3.value=3;
        list2.next = list3;
        LNode list4 = new LNode();
        list4.value=4;
        list3.next = list4;
        list4.next=null;
        LNode res = reverseLinkedList(list);
        while(res!=null){
            System.out.println(res.value);
            res = res.next;
        }
    }
}
