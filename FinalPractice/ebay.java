Parteek Makkar

Given array [5,2,4,1,4,6,3] find the duplicate
--Only 1 duplicate
--Values 1 to N are guaranteed

Method : a[i] xor 1=i xor
Runtime : O(
Space : 


Part 2:
Given array [1,2,3,4,4,5,6] find the duplicate .. [1,2,3,4,5,6,6] etc..
--Only 1 duplicate
--Values 1 to N are guaranteed
--return only the duplicate number.

code it

method:  
int returnDuplicate(int[] a){
    int high = a.length-1;
    int low = 0;    
    return helper(a,low,high);
}

int helper(int[] a,int low, int high){
    if(low>high)
      return 0;
    int mid = (high+low)/2;
    if(mid+1<=a.length-1 &&  a[mid]==a[mid+1]){
         return a[mid];
    }
    if(mid-1>=0 && a[mid]==a[mid-1]){
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
runtime:
Space:






