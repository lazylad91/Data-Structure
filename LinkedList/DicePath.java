import java.math.BigInteger;

public class DicePath {
    public static void main(String args[]){
    	BigInteger[] arry = new BigInteger[611];
    	for(int i=0; i< 611; i++){
    		arry[i]=null;
    	}
        System.out.println(calNoOfPath(610,arry));
    }
    
    public static BigInteger calNoOfPath(int n, BigInteger[] mim){
        if(n==0)
        return new BigInteger("1");
		else if(n<0)
		return new BigInteger("0");
		else if(mim[n]!=null)
		return mim[n];
        else
        mim[n] = calNoOfPath(n-1,mim).add(calNoOfPath(n-2,mim)).add(calNoOfPath(n-3,mim)).add(calNoOfPath(n-4,mim)).add(calNoOfPath(n-5,mim)).add(calNoOfPath(n-6,mim));
        return mim[n];
    }
}