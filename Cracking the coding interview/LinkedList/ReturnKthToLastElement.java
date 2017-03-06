/* Version-1
Recursive solution - make a recursive call and assign counter=call+1 with it
Base case is - if list=null then return 0
So when the recursion hits the end (Means if lenght is 8 and recursion hit the 8th element-counter will
be 1 so element will 8th which is last.)
Thats what we need to return, i mean we are starting counting from the end now so when counter will be equal
to k we will print that.
*/

public class ReturnKthToLastElement{
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
        printKthToLastElement(l,3);
    }
    public static int printKthToLastElement(LinkedList l,int k){
        if(l==null)
        return 0;
        
        int counter = printKthToLastElement(l.next,k)+1;
        
        if(counter==k)
        System.out.println(l.data);
        
        return counter;
    }
}