public class Divide {
    
/*    so Normal division x/y in brute force work like
    subtract y from x till the time x<y so no of times we substracted
    y from x is quotient and what is left is remainder
    This is brute force method what we can get out of it is that
    x - 2^k y where k can be maximum such as x > 2^k y but difference < x 
    If we can find the maximum value of k then thats the quotient and
    difference is remainder  for example 14/2 will be 14-2 2 ^ 2 is equal to 14-8 where k = 4
    and what left is 6 now so 6 - 2 2 ^1  now k=2 so 4+2 = 6 what left is 2 
    for this it will 2 - 2 * 2^0 so here k = 6+1 which is 7 and remainder is 0
    We will start with power 32 and keep decrementing to get the optimized solution
     */
    public static void main(String args[]){
       System.out.println("15 divided by 3 is "+ divide(15L,3L)); 
    }
    
    public static long divide(long x, long y){
            long result = 0;
            int power = 32;
            long ypower = y << 32;
            while(x >= y){
                while(ypower > x){
                    ypower >>>=1;
                    power--;
                }
                x = x-ypower;
                result += 1L << power;
            }
            
            return result;
    }
}