public class BinarySearch {
    public static void main(String[] args){
        int[] a = {0,1,2,3,4,5,6,7,8};
        System.out.println(binarySearch(a,0,a.length-1,4));
    }
    
    public static int binarySearch(int[] a, int low, int high, int key){
        int mid = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(a[mid] == key){
            return mid;
            }
            else if(a[mid]<key)
                low = mid+1;
            else 
                high = mid-1;
        }
        
        return -1;
    }
}