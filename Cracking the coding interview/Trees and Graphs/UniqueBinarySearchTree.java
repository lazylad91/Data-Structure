public class Solution {
    int[] a;
    public int numTrees(int n) {
        if(a==null)
        a = new int[n+1];
        if(n==1 || n==0)
        return 1;
        
        if(a[n]!=0)
        return a[n];
        
        else{
            for(int i=1; i<=n; i++){
                a[n] = a[n] + numTrees(i-1)*numTrees(n-i);
            }
        return a[n];
        }
    }
}