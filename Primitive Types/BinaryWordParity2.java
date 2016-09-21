class BinaryWordParity2 {
    
    public static void main(String[] args){
        int x =11;
        System.out.println(0xFFFF);
        System.out.println("Parity of 11 is "+ parity(x));
    }
            
            // Memorize formula x &= (x-1) it will make leftmost 1 to zero
            // So 11 is 1011 so it will become 1010 then 1000 then 0000
            // So this loop will run 3 times now.
            // we are taking result as 0 so for every 1 found it will change to 1 
            // and then to 0 and again to 1 so for 11 it will be 1 as it will run odd no of times
            // So time complexity of this is 3
    public static short parity(long x){
        short result = 0;
        while(x!=0){
            result ^=1;
            System.out.println("result " + result);
            x &= (x-1); 
            System.out.println("x " + x);
        }
        return result;
    }
}