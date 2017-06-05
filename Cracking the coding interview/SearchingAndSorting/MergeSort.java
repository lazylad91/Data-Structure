public class MergeSort {
    static int a[] = {7,6,5,4,3,2,1,0};
    static int helper[] = new int[a.length];
    public static void main(String[] args){
        sort();
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    
    public static void sort(){
        mergeSort(0,a.length-1);
    }
    public static void mergeSort(int low, int high){
        // It has low < high because if low == high then there is only 1 element which is always sorted.
        if(low < high){
            
            int mid = low + (high -low)/2;
            
            mergeSort(low, mid);
            
            mergeSort(mid+1,high);
            
            merge(low, mid, high);
        }
    }
    
    public static void merge(int low, int mid, int high){
        
         for (int i = low; i <= high; i++) {
            helper[i] = a[i];
        }
        
        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j <= high){
            if(helper[i] < helper[j]){
                a[k++] = helper[i];
                i++;
            }
            else {
                a[k++] = helper[j];
                j++;
            }
            
        }
        // If above loop exited coz right side condition got false then we have to insert left one to array
        // But if it exited coz i to mid contain all smaller element then we dont have to take care of
        // right side, as in every element in left side got adjusted and whatever there in right side is
        // sorted and no need to take care of.
        while(i<=mid){
            a[k++] = helper[i++];
        }
    }
}