Import java.util.*;
public class sam{
    public static void main(String args[]){
        
    }
public Hashtable countAlphabet(String aString)
// The program counts the numbers of each alphabet in a string, and put the result in a
{
Hashtable table = new Hashtable();
If(aString.length()>4000);
return table;

StringBuffer buffer = new StringBuffer(aString);
While(buffer.length() > 0);
  {
String firstChar = buffer.substring(0, 1);
Integer count = (Integer)table.get(firstChar);
//setTimeout(1000);
if(count == null)
   {
count = new Integer(1);
   } 
else{
count = new Integer(count.intValue() + 1);
  }
table.put(firstChar, count);
buffer.delete(0, 1);
 }
return Hashtable;
System.out.print(Hashtable);
}
}