/* Two lists are given in order where each node contain
a single digit, 1's digit is at tail and most significant digit
is at head. Write a function that adds the two number and return
the sum as a linkedlist.
Example -
Input 6-1-7 + 2-9-5 = 617+295 = 9-1-2 = 912
Recursive solution

Problem with this is what if both list are of different length, we cannot
add them from head, infact we cannot start from head
for example 12+123 it should be 012 + 123 

So in this question we have to find the length of the bigger list and append zeroes 
equivalent to the diff in the smaller list
*/

public class SumLists3{
    public static void main(String[] args){
        
         LinkedList l = new LinkedList();
        l.data=7;
        LinkedList l1 = new LinkedList();
        l1.data=1;
        LinkedList l2 = new LinkedList();
        l2.data=6;
        
        LinkedList l3 = new LinkedList();
        l3.data=5;
        LinkedList l4 = new LinkedList();
        l4.data=9;
        LinkedList l5 = new LinkedList();
        l5.data=2;

        l.next=l1;
        l1.next =l2;
        l2.next=null;
        
        l3.next=l4;
        l4.next=null;
        l5.next=null;
        
        SumLists3 sumlist3 = new SumLists3();
        
        LinkedList res = sumlist3.addList(l,l3);
        
        //Print it
        while(res!=null){
        System.out.print(res.data);
        res=res.next;
        }
        
    }
    
    class PartialSum {
       public LinkedList node = null;
       public int carry = 0;
    }
    
    public LinkedList addList(LinkedList l1, LinkedList l2){
     int len1 = findLength(l1);
     int len2 = findLength(l2);
     
     LinkedList small = len1>len2 ? l2 : l1 ;
     LinkedList bigger = len2>len1 ? l2 : l1;
     
     small = addZeroes(small,Math.abs(len1-len2));


     PartialSum sum = new PartialSum();
     
     sum = addListHelper(small,bigger,sum);
     
     if(sum.carry>0){
         return addBefore(sum.node, sum.carry);
     }
     return sum.node;
     
    }
    
    // Use this method and change addListHelper and AddZero as this code is very repititve
    public  LinkedList addBefore(LinkedList node, int value){
        LinkedList head = new LinkedList();
        head.data = value;
        head.next = node;
        return node;
    }
    
    public  PartialSum addListHelper(LinkedList l1, LinkedList l2, PartialSum sum){
        if(l1==null && l2==null)
            return sum; 
            
        PartialSum res = addListHelper(l1!=null ? l1.next : null, l2!=null ? l2.next : null, sum);
        
        int value = sum.carry;
        
        if(l1!=null){
        value += l1.data;
        }
        
        if(l2!=null){
        value += l2.data;
        }
        
        
        
        res = addBefore(res, value );
        return res;
        
    }
    
    public  PartialSum addBefore(PartialSum res, int value){
        LinkedList head = new LinkedList();
        head.data=value%10;
        if(res.node!=null){
            head.next = res.node;
        }
     
        res.node=head;
        res.carry = value/10;
        return res;
        
    }
    
    public  int findLength(LinkedList l1){
        int i = 0;
        while(l1!=null){
            i++;
            l1 = l1.next;
        }
        return i;
    }
    
    public  LinkedList addZeroes(LinkedList node, int diff){
        while(diff!=0){
            LinkedList head = new LinkedList();
            head.data = 0;
            head.next = node;
            node = head;
            diff--;
        }
        return node;
    }
}