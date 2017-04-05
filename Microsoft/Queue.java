import java.util.*;
public class Queue<T>{
    
    private LinkedList<T> queue;
    
    public Queue(){
        queue = new LinkedList<T>();
    }
    
    public void enqueue(T object){
      queue.addLast(object);
    }
    
    public T dequeue(){
        if(queue.size()>0)
        return queue.removeFirst();
        else 
        return null;
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public int size(){
        return queue.size();
    }
}