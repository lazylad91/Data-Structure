/* This is a second method using bit manipulation
like we will take a bitvector = 0
so we will flip a bit, everytime we find the same character
we will start from 0, its like switching on the button
and off. if we do it even number of times then switch will
be off, but odd then it will be ON state. So we can afford only
1 switch max to be ON and rest should be off for it to be palindrome
of permutation.*/

// Most important thing is 2^n is equal to Sum(2^ - 2^n-1)+1
// Or u can use 2^n = 2^n+1-1

public class PalindromePermutation2{
    public static void main(String[] args){
        System.out.println(checkPalindromePermutation("atc%cta"));
    }
    public static boolean checkPalindromePermutation(String s){
        int bitVector = 0;
        for(int i=0; i<s.length(); i++){
            if(checkValidChar(s.charAt(i))){
               bitVector= flipBit(bitVector,Character.getNumericValue(s.charAt(i)));
            }
        }
        
        // check if only 1 is there or not
        if((bitVector&(bitVector-1))==0)
        return true;
    return false;    
    }
    public static int flipBit(int x,int index){
        int mask = 1<<index;
        x = x ^ index;
        return x;
    }
    public static boolean checkValidChar(char c){
        if(c>='a' && c<='z')
            return true;
        return false;
        }
}