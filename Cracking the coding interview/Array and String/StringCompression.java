/* aaabbbbccssfdd sshould become a3b4c2s2f1d2 otherwise return original
Use string builder as string concat use n2*/
public class StringCompression {
 public static void main(String[] args){
     System.out.println(compressString("aaabbbbccssfdd"));
 }
 
 public static String compressString(String str){
     int consecutiveCount = 0;
     StringBuilder stb = new StringBuilder();
     for(int i=0; i<str.length(); i++)
     {
         consecutiveCount++;
         // i+1 is string.length means i is at last character, we dont need to check right side, it will throw exception.
         if(i+1==str.length() || str.charAt(i+1) != str.charAt(i)){
             stb.append(str.charAt(i));
             stb.append(consecutiveCount);
             consecutiveCount=0;
         }
     }
     
     return stb.length() < str.length() ? stb.toString() : str;
 }
}