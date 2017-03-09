/*There are three ways to achieve this
1 - reverse the list and compare
2 - Push half the list in stack and then compare other half - obviously if its odd length we have to skip middle element
3 - Recursion recurse it till half and then check it with other half while coming back
Lets start with the basic version i.e - reverse the list*/

public class Palindrome{
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
        LinkedList clone = ReverseAndClone(l);
        
        CheckEquals(clone,l);
    }
    
    public static void CheckEquals(LinkedList clone, LinkedList node){
        Boolean palindrome = true;
        while(clone!=null || node!=null){
            if(clone.data!=node.data){
            palindrome=false;
            break;
                
            }
            clone = clone.next;
            node = node.next;
        }
        if(palindrome)
        System.out.println("palindrome");
        else
        System.out.println("nt a palindrome");
    }
    
    public static LinkedList ReverseAndClone(LinkedList node){
    LinkedList last= null;
    while(node!=null){
        LinkedList clone = new LinkedList();
        clone.data = node.data;
        clone.next = last;
        last = clone;
        node = node.next;
    }
    return last;
        
    }

}