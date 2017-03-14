import java.util.*;

// Using 2 stacks
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