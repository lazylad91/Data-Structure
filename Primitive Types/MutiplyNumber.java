/*Write a program that multiplies two nonnegative integers. The only operators you are allowed to use are :
1 assignment
2 the bitwise operators
3 equality checks and booleans combination*/


class MutiplyNumber {
    public static void main(String[] args){
        System.out.println("Multiplication of 2 numbers are 8 and 9  = " + multNumber(8L,9L));
    }
    
/*    Logic for multiplication for 3*5 is adding 3 5 times.
    That will be the brute force and complexity is too high
    Lets try it with binary multiplication by imagining that 
    CPU doesnt have dedicate hardware for 
    so how binary multiplication works?
    for ex 1101 * 1001 is equivalent to
    1001
    1101
--------------
    1001
   00000
  100100   
 1001000
-------------
1110101

  adding thing works like below
    1 + 1 = 1(carry)  0 
    1 + 0 = 1
    0 + 1 = 1
    0 + 0 = 0
*/    

public static long multNumber(long a, long b){
        long result = 0;
        while(a!=0){
            if((a & 1L) != 0){
                result = sum(result,b);
            }
            a>>>=1;
            b<<=1;
        }
        return result;
}

public static long sum(Long a, Long b){
    // carry in is which we are getting from previous calculation
    long sum =0, carryin=0, tempA =a, tempB = b, k =1;
    while(tempA!=0 || tempB!=0){
        long ak = k & a, bk = k & b;
        // carry out is which we are calculating for next transaction and will put in carryin after current calculation
        long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
        sum = sum | (ak^bk^carryin);
        carryin = carryout << 1;
        k <<=1;
        tempA >>>= 1;
        tempB >>>= 1;
    }
    return sum | carryin; // Oring with carryin is to add anything which is left
}
    
}