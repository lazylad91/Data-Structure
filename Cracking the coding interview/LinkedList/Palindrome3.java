/* Recursive solution */

public class Palindrome3 {
    public static void main (String[] args){
    
    
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
        Palindrome3 p3 = new Palindrome3();
     System.out.println(p3.isPalindrome(l));
        
    }
    
    class Result{
        public LinkedList node;
        public boolean result;
        
        public Result(LinkedList node1, boolean result1){
            node=node1;
            result = result1;
        }
    }
    
    public boolean isPalindrome(LinkedList node){
        int length = findLength(node);
        Result p = isPalindromeRecurse(node, length);
        return p.result;
    }
    
    public Result isPalindromeRecurse(LinkedList head, int length){
        if(length<=0){
        return new Result(head,true);
        }
        else if(length==1){
            return new Result(head.next,true);
        }
        
        Result p = isPalindromeRecurse(head.next, length-2);
        
        System.out.println("p" + p.node.data + " h " + head.data );
        
        if(!p.result){
        return p;
        }
        
        if(p.node.data!=head.data){
            p.result = false;    
        }
        
        p.node = p.node.next;   // Going to the next node for comparison
        
        return p;
    }
    
    public static int findLength(LinkedList node){
        int i = 0;
        while(node!=null){
            i++;
            node = node.next;
        }
        return i;
    }
    
}