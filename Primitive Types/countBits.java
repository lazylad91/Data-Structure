class countBits {
    
    public static void main(String[] args){
        System.out.println("Hello world");
        System.out.println("No of 1 in 11 "+countBitsOfInteger(11));
    }
    
    public static int countBitsOfInteger(int n){
        int numbits = 0;
        while(n!=0){
            numbits = numbits + (n&1);  //  return 1 when both least significant bit of n and 1 are both 1 i.e 1101 & 0001 will return 1
            n>>>=1;    // Will shift bit 1101 to 110
        } 
        return numbits;
    }
}