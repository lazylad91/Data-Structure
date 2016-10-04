class FindMinimumVariant {
    public static void main(String[] args){
        solution(623315);
    }
    public static int solution(int X) {
        // write your code in Java SE 8
        String ns = String.valueOf(X);
        int len = ns.length();  // Length of the integer
        int i=0;
        int max = Integer.MIN_VALUE;
        int average = 0;
        int avg = 0;
        int number;
        String prefix="";
        while(i<len-1)
        {
            if(i!=0){
                 prefix = ns.substring(0,i);
            }
            //average = (Character.getNumericValue(ns.charAt(i))+Character.getNumericValue(ns.charAt(i+1)))/2;
            System.out.println("zzzzz" +((ns.charAt(i)-'0')+(ns.charAt(i+1)-'0'))/2.0);
            average = (int) Math.round(((ns.charAt(i)-'0')+(ns.charAt(i+1)-'0'))/2.0);
            System.out.println("valuue of i ---"+(ns.charAt(i)-'0'));
            System.out.println("valuee 0f i+1 -"+(ns.charAt(i+1)-'0'));
            
            avg=Math.round(average);
            String remaining = ns.substring(i+2,len);
            remaining = prefix+avg + remaining;
            System.out.println(remaining);
            if(Integer.parseInt(remaining)>=max)
                max = Integer.parseInt(remaining); 
            i++;  //Incrementing the counter
        }
        return max;
    }
}