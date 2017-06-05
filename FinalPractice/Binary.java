public class Binary {
    public static void main(String[] args){
        System.out.println(findPalindrome(8));
    }
    
    public static boolean findPalindrome(int x){
        int size = Integer.SIZE-Integer.numberOfLeadingZeros(x);
        int j = 0;
        int mask = 1;
        boolean odd = false;
        if(size%2!=0){
            odd = true;
        }
        while(true){
            if(size==j && !odd)
                break;
            else if(size-1==j)
                break;
            else{
            int left = (x & (mask<<--size))>>size;
            System.out.println(left);
            int right = x & (mask<<j++);
            System.out.println(right);
            if(left!=right)
            return false;
            }
        }
        return true;
    }
}