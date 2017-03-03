/* First way is to sort both the string
and then use equal method if equal then
return true else false */
public class Check2StringPalindrome{
    public static void main(String[] args){
        System.out.println(checkPalindrome("catbat","tcabta"));
    }
    
    public static boolean checkPalindrome(String s,String t){
        if(s.length()!=t.length()) // As if lenghts are not equal then cant be palindrome
        return false;
        
        int[] letterCounts = new int[128];
        for(int i=0; i<s.length(); i++)
        {
            int val = s.charAt(i);
            letterCounts[val]++;
        }
        for(int i=0; i<t.length();i++){
            int val = t.charAt(i);
            letterCounts[val]--;
            if(letterCounts[val]<0)
            return false;
        }
        return true;
    }
}