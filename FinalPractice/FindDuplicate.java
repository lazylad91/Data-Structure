public class FindDuplicate {
    
    public static void  main(String[] args){
        int[] a = {1,2,3,4,5,6,6,7};
        System.out.println(returnDuplicate(a));
    }
static int returnDuplicate(int[] a){
    int high = a.length-1;
    int low = 0;    
    return helper(a,low,high);
}

static int helper(int[] a,int low, int high){
   try{
    if(low>high)
      return 0;
    int mid = (high+low)/2;
    if((mid-1>=0 && a[mid]==a[mid-1]) || (mid+1<=a.length-1 &&  a[mid]==a[mid+1])){
        return a[mid];
    }
    else{
    int left = helper(a,low,mid-1);
    if(left!=0)
    return left;
    int right = helper(a,mid+1,high);
    if(right!=0)
    return right;
    }
   }
   catch(Exception ex){
       System.out.println(ex);
       System.exit(1);
   }
    return 0;
}
}