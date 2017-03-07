/* Version-2
More optimal, as run in O(n) and space o(1) as no recursive calls
*/

public class ReturnKthToLastElement2{
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
        System.out.println(printKthToLastElement(l,3).data);
    }
    public static LinkedList printKthToLastElement(LinkedList l,int k){
        LinkedList p1 = l;
        LinkedList p2 = l;
        int i=0;
        while(i < k){  // 1-2-3-4-5-6-7  k=3 p1=1 p2=1
            if(p1==null)
            return null;
            p1=p1.next; 
            i++;
        }           
        // p1=4 and it will run till p1 will move to null
        while(p1!=null) 
        {
            p1=p1.next;
            p2=p2.next;
        }
        
        return p2;
    }
}