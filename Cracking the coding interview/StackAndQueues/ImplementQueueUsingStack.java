import java.util.*;

// Using 2 stacks
public class ImplementQueueUsingStack {
    public static void main(String[] args){
        ImplementQueueUsingStack sm = new ImplementQueueUsingStack();
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
        Stack<T> s2;
        
        public MyQueue(){
            s1 = new Stack<T>();
            s2 = new Stack<T>();
        }
        
        public int size(){
            return s1.size() + s2.size();
        }
        
        public void push(T t){
            s1.add(t);
        }
        
        public T peek(){
            shiftStack();
            return s2.peek();
        }
    
        
        public T pop(){
            shiftStack();
            return s2.pop();
        }
        
        public void shiftStack(){
            if(s2.empty()){
                while(!s1.empty()){
                    s2.push(s1.pop());
                }
            }
        }
        
    }
}