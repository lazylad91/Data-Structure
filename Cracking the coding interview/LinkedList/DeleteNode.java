/* u have give access to the node which has to be deleted
you cannot access previous node, so what u can do is copy the 
next node into current node and deletes the next of current*/
public class DeleteNode{
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
        removeNode(l3);
         while(l!=null){
        System.out.println(l.data);
        l=l.next;
        }
    }
    public static void removeNode(LinkedList l3){
        if(l3==null)
        return;
        if(l3.next==null){
        l3=null; 
        return;
        }
        else{
            l3.data = l3.next.data;
            l3.next = l3.next.next;
        }
        return;
    }
}