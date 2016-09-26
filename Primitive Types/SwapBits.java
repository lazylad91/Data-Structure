class SwapBits {
    
    public static void main(String[] args){
        System.out.println("Swap bits of 73 at 1 and 6th position it should result in 11 and answer is " + swapBits(73,1,6));
    }
    
    public static long swapBits(long x,int i,int j){
        // first we will check the bits at i and j, if they both are same we dont need to swap them
        if( ((x>>>i) & 1) != ((x>>>j) & 1)){
            // in XOR if you have to flip the bit just xor the bit by 1
            // It will always result in opposite so 1 ^ 1 = 0
            // on the other hand 1 ^ 0 = 1
            // So now we just have to make a bitmask where there will be 1 at i and j position and xor with
            // the real number
            // Also if u xor with 0 that number never change as 0 ^ 0 = 0 and 0 ^ 1 = 1
            // For bitmask
            // The time complexity of this is O(1)
            long bitmask = (1L<<i) | (1L<<j);
            x ^=bitmask;
        }
        
        return x;
    }
}