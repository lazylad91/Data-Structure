import java.util.*;

class Node<T1,T2> {
    T1 key;
    T2 value;
    Node pre;
    Node next;
    
    public Node(T1 key, T2 value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<T1,T2> {
    int capacity;
    HashMap<T1,Node<T1,T2>> map = new HashMap<T1,Node<T1,T2>>();
    Node head=null;
    Node end = null;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    
    public T2 get(T1 key){
        if(map.containsKey(key)){
            Node<T1,T2> n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
            }
          return null;
        }
        
   public void remove(Node n){
       if(n.pre!=null){
           n.pre.next = n.next;
       }
       else{
           head = n.next;
       }
       
       if(n.next!=null){
           n.next.pre = n.pre;
       }
       else{
           end = n.pre;
       }
   }
   
   public void setHead(Node n){
       n.next = head;
       n.pre = null;
       
       if(head!=null)
           head.pre = n;
       head = n;
       
       if(end==null)
           end = head;
   }
   
   public void put(T1 key, T2 value) {
       if(map.containsKey(key)) {
           Node old = map.get(key);
           old.value = value;
           remove(old);
           setHead(old);
       }
       else{
       Node<T1,T2> newNode = new Node<T1,T2>(key,value);
       if(map.size()>=capacity) {
               map.remove(end.key);
               remove(end);
               setHead(newNode);
           }
        else{
            setHead(newNode);
        }
        map.put(key,newNode);
       }
   }
   
    public static void main(String[] args){
    LRUCache<Integer,String> myCache = new LRUCache<Integer,String>(3);
    myCache.put(1,"Green");
    myCache.put(2,"Red");    
    System.out.println(myCache.get(1));
    }
}

