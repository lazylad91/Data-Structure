class BinaryWordParity {
    public static void main(String[] args){
        System.out.println("Parity of 11 is "+ calculateParity(11));
    }
    
    /*
    Trick is XOR it gives 1 only if both bit are different.
    so we will be going to xor between bits of the number from least
    significant bit till most. For ex 11 - 1011 parity= (1^(0^(1^1))) will result 1
    */
    public static int calculateParity(int n){
        int result = 0;
        while(n!=0){
            result ^= (n&1);  // This will give the least significant bit of number and it will be xor with previous result
            n >>>= 1;        
        }
        return result;
        
    }
}