public class QuickSort {
    static int[] a = {7,8,5,3,2,1,0,15,14,13,12};
    public static void main(String[] args){
        quicksort(0,a.length-1);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    
    public static void quicksort(int low, int high){
            int i = low;
            int j = high;
        // this iteration will go till i and j both are equal to pivot element    
        if(i<=j){
            int pivot = a[i + (j-i)/2];
            
            while(a[i]<pivot){
                i++;
            }
            
            while(a[j]>pivot){
                j--;
            }
            // we are using i = j for the case when pivot element is at its right position
            // we are moving i to i+1 and j to j-1
            // so this if condition last run will be when i and j = pivot element
            if(i<=j){
                swap(i,j);
                i++;
                j--;
            }
        }
        
        if(low<j){
            quicksort(low,j);
        }
        if(i<high){
            quicksort(i,high);
        }
    }
    
    public static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}