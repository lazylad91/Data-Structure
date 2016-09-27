class ReverseNumber{
    public static void main(String args[]){
        System.out.println("reverse of number 314 is " + reverse(314l));
        System.out.println("reverse of number 314 is " + reverse(-314l));
    }
    
    public static long reverse(long x){
        boolean isNegative = x < 0;
        long absX = Math.abs(x);
        long result = 0;
        while(absX!=0){
            result = result * 10 + absX % 10;
            absX = absX / 10;
        }
        
        return isNegative ? -result : result;
    }
}