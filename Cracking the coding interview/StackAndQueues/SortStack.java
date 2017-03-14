/*
So the idea is u have to sort stack and u can use one aditional stack - not any
other data structure. Now how we can approach this problem.
We have to sort stack in increasing order, so we should put data in second stack in
decreasing order.
So we should pop 1 element from stack 1 and put it in temp.
Now we should see the top element in stack 2 if its greater then temp then we should pop that
and put that in stack 1. We should pop elements from stack 2, till we find right place for temp
So what after that- i mean when u found place for temp. You repeat the same process, till 
stack 1 is empty. 
*/

import java.util.*;

public class SortStack {
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(8);
        s1.push(1);
        s1.push(9);
        s1.push(2);
        s1.push(5);
        s1.push(23);
        s1 = sort(s1);
        
        while(!s1.empty()){
            System.out.println(s1.pop().intValue());
        }
    }
    
    public static Stack<Integer> sort(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.empty()){
            int temp = s1.pop().intValue();
            while(!s2.empty() && temp<s2.peek()){
                s1.push(s2.pop());
            }
            
            s2.push(temp);
        }
        
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        
        return s1;
    }
}