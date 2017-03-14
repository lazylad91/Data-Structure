import java.util.*;

// Using 1 stacks
// This is the method which reverse the stack everytime something is added and keep the data as in queue, which
// is expensive.
// Better way to do this is - during dequeue recurse it and put every popped value in temp.
// When u reached at last value pop it and return it. and then put everything back in stack as it is.
// Link - https://github.com/sagardafle/DataStructures-Algorithms/blob/master/DataStructures/Queues/Implementation/QueueUsing1Stack.java


public class ImplementQueueUsing1Stack {
    public static void main(String[] args){
        ImplementQueueUsing1Stack sm = new ImplementQueueUsing1Stack();
        MyQueue<Integer> que = sm.new MyQueue<Integer>();
        que.push(5);
        System.out.println(que.peek());
        que.push(8);
        System.out.println(que.peek());
        que.push(3);
        System.out.println(que.peek());
        que.push(1);
        System.out.println(que.peek());
        que.push(11);
        System.out.println(que.peek());
        que.push(2);
        System.out.println(que.peek());
        que.push(7);
        System.out.println(que.peek());
        que.push(4);
        System.out.println(que.peek());
        que.pop();
        System.out.println(que.peek());
        que.pop();
        System.out.println(que.peek());
        que.pop();
        System.out.println(que.peek());
    }
    
    public class MyQueue<T> {
        Stack<T> s1;
        
        public MyQueue(){
            s1 = new Stack<T>();
        }
        
        public int size(){
            return s1.size();
        }
        
        public void push(T t){
            reverseStack();
            s1.push(t);
            reverseStack();
        }
        
        public T pop(){
            return s1.pop();
        }
        
        public T peek() {
            return s1.peek();
        }
        
        public void insertAtBottom(T t){
            if(s1.empty()){
                s1.push(t);
            }
            else{
            T temp = s1.pop();
            insertAtBottom(t);
            s1.push(temp);
            }
        }
        
        public void reverseStack(){
            if(!s1.empty()){
                T temp = s1.pop();
                reverseStack();
                insertAtBottom(temp);
            }
        }
    }
}