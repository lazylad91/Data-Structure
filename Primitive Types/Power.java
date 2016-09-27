class Power {
    
    public static void main(String args[]){
        System.out.println("Power of 5 raise to power 3 is " + findPower(5.0,3));
    }
    
/*    So for brute force solution o(2^n) is the time complexity 
    that is multiply x y times
    For optimized solution lets treat it as a mathematical problem
    for ex x^10 = x^5 * x^5 = x^4 x * x * x^4
    so its like if power is odd then x^y = x * x ^ (y-1)/2 * x ^ (y-1)/2 
    if power is even then x^y = (x ^ (y/2)) * (x ^ (y/2))
    for binary powers if LSB is 0 its even if its 1 its odd
    We will be using binary solution
    This solution will have time complexity of O(n) */
    
    public static Double findPower(Double x, int y){
        Double result = 1.0;
        int power = y;
        if(y<0){
            power = -power;
            x = 1.0/x;
        }
        while(power!=0){
            if((power&1) != 0)
            {
                result *= x;
            }
            x *=x;
            power >>>=1;
        }
        
        return result;
    }
}