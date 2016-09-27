class CheckPalindrome {
    
    /*Check if decimal integer is palindrome or not*/
    
    public static void main(String args[]){
        System.out.println("The number 123321 is: "+ isPalindrome(123321));
        System.out.println("The number 1235321 is: "+ isPalindrome(1235321));
        System.out.println("The number 12334321 is: "+ isPalindrome(12334321));
    }
    /*So for bruteforce algo we can convert it into string
    and check each character or reverse it and see if its 
    the same or not after reversing, it will take o(n) time
    and space complexity. We can reduce the space complexity to o(1)
    A quick learning formula for that is no of digits in integer is 
    equal to log base 10 of integer plus 1. We can find Least significant
    digit by mod 10 and MSD by mod 10 raise to power no of digits-1.
    We will check if both are equal we will remove them and continue
    other wise return false*/
    public static boolean isPalindrome(int x){
        if(x<0)
        return false;
        int noOfDigits = (int)Math.floor(Math.log10(x))+1;
        int msdMask = (int)Math.pow(10,noOfDigits-1);
        for(int i=0; i<noOfDigits/2; i++){
            if(x%10 != x/msdMask)
                return false;
                
            x = x%msdMask; // removing MSD and it should be the first one to remove before LSD as otherwise we have to change msdMask
            x = x/10;  // removing LSD
            msdMask = msdMask/100; // Mask will go two digit down as 2 digits are removed
        }
        return true;
    }
}