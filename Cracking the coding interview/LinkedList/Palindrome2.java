import java.util.*;

public class Palindrome2{
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
        l4.data=3;
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
     System.out.println(CheckPalindrome(l));
    }
    
    public static boolean CheckPalindrome(LinkedList node){
        LinkedList slow = node;
        LinkedList fast = node;
        
        Stack<Integer> st = new Stack<Integer>();
        
        // fast will be equal to null-in case of even and fast.next will be equal to null
        //in case of odd list. Even - it will stop at first element of other half of list Fast = Null
        //and for Odd - it will stop at middle element of list. Fast = Last element
        while(fast!=null && fast.next!=null) {
            st.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Skippng mid element for odd lenght list
        if(fast!=null){
            slow = slow.next;
        }
        
        while(slow!=null){
            int top = st.pop().intValue();
            if(slow.data != top){
                return false;
            }
            slow = slow.next;
        }
        
        return true;
    }
    
}