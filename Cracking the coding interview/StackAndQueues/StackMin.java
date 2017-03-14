/* Design a stack in which except push and pop, there will be function min which will give minimum
number in stack at O(1)

Solution 1 - Keep another stack and at every step push min at the new tax
for ex - 
push 3 - push 3 as min
push 5 - min<5 so push 3 again
push 1 - min>3 so push 1 now

pop 1 so pop 1 value from another stack too

but in this solution we have to maintain a new stack of length of number of elements of stack.
Instead of this what we can do is only maintain the new min
For ex - if we have 1000 of entry and 1st entry was 1 which was also minimum at each level
We will just put 1 and nothing else 
*/

import java.util.*;

public class StackMin {
    public static void main(String[] args){
        StackMin sm = new StackMin();
        StackWithMin2 s1 = sm.new StackWithMin2();
        s1.push(5);
        System.out.println(s1.min());
        s1.push(8);
        System.out.println(s1.min());
        s1.push(3);
        System.out.println(s1.min());
        s1.push(1);
        System.out.println(s1.min());
        s1.push(11);
        System.out.println(s1.min());
        s1.push(2);
        System.out.println(s1.min());
        s1.push(7);
        System.out.println(s1.min());
        s1.push(4);
        System.out.println(s1.min());
        s1.pop();
        System.out.println(s1.min());
        s1.pop();
        System.out.println(s1.min());
        s1.pop();
        System.out.println(s1.min());
        
    }
    
    class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> s2;
        public StackWithMin2(){
            s2 = new Stack<Integer>();
        }
        
        public void push(int x){
            if(x<min()){
                s2.push(x);
            }
            super.push(x);
        }
        
        public Integer pop(){
            int val = super.pop();
            if(min()==val)
            s2.pop();
            return val;
        }
        
        public int min(){
            if(s2.isEmpty()){
                return Integer.MAX_VALUE;
            }
            else
            return s2.peek();
        }
    }
}