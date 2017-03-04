/* There are 3 ways to do it
1st is count the number of characters, every character should
be in even number or 1 odd character count and rest even
To check all this one way is count it and second is bit manipulation
here we gonna count it in a best possible optimize way 
and in next version we will try bit manipulation */

public class PalindromePermutation{
    public static void main(String[] args){
        System.out.println(checkPalindromePermutation("atcocta"));
    }
    public static boolean checkPalindromePermutation(String s){
        char[] letterCounts = new char[128];
        int odd = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(checkValidChar(s.charAt(i))){
                letterCounts[s.charAt(i)]++;
                if(letterCounts[s.charAt(i)]%2==1)
                    odd++;
                else
                    odd--;
            }
        }
        if(odd==1 || odd ==0)
            return true;
        return false;    
    }   
    public static boolean checkValidChar(char c){
        if(c>='a' && c<='z')
            return true;
        return false;
        }
}