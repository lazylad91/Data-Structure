//* Find a closest integer with the same weight *//

public class ClosestInteger {
    
    public static void main(String[] args){
        System.out.println("Closest integer of 10 is "+ findClosestInteger(10L));
    }
    /* Weight of integer is number of 1 in binary number like in 1101 weight is 3
    In this problem we have to find n which is closest integer of m which got the same weight and
    such that |m-n| is minimum
    Brute force approach is that we find weight of each consecutive number and select 
    which got the same weight and minimum difference but it involve lot of calculation
    for large value number
    Mathematical proof is that if we flip 2 different bits in number its weight remain
    same like 1101 so if we flip right most 2 digit it will become 1110 so weight is same and 
    difference is 2^k1 - 2^k2 that is in this case 2^1 - 2^0 which is 1. k1>k2 
    so we have to start from right most bits and k1 can be any index except 0 and k2 be next bit. 
    To find the answer we have to minimize k1 and k2 should be as closer to k1
    */
    public static long findClosestInteger(Long x){
        int noOfBit = 63; // As only positive integers are considered        
    for(int i=0; i<63-1 ; ++i){
           if (((((x >>> i) & 1)==0) && ((( x >>> (i+1)) & 1))==1)) {
               x ^= (1L << i) | (1L << (i+1));
               return x;
           }
        }
        return 0;
    }
}