public class Divide {
    
/*    so Normal division in brute force work like
    subtract */
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