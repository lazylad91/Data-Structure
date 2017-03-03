/* First way is to sort both the string
and then use equal method if equal then
return true else false */
public class Check2StringPermutation{
    public static void main(String[] args){
        System.out.println(checkPermutation("catbat","tcabta"));
    }
    
    public static boolean checkPermutation(String s,String t){
        if(s.length()!=t.length()) // As if lenghts are not equal then cant be permutation
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