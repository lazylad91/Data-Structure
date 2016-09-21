class BinaryWordParity3 {
    
    public static void main(String[] args){
        
        System.out.println(" Parity of word 11010111 is " + parity(215));
    }
    
        public static short parity(int x){
            x ^= x >>> 32;
            x ^= x >>> 16;
            x ^= x >>> 8;
            x ^= x >>> 4;
            x ^= x >>> 2;
            x ^= x >>> 1;
            return (short) (x & 1);
        }
}