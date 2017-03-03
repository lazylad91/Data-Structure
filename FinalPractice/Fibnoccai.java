import java.math.BigInteger;

public class Fibnoccai {
    public static void main(String args[]){
        System.out.println(calFib(8181));
    }
    
    public static BigInteger calFib(int n){
        if(n==0)
        return new BigInteger("0");
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        for(int i=2; i<n; i++)
        {
           BigInteger c = a.add(b);
            a=b;
            b=c;
        }
        return a.add(b);
    }
}