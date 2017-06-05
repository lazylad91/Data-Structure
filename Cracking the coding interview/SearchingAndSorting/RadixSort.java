public class RadixSort {

public static void main(String[] args){
    int[] a = {0,8,123,23,21,54,215,29,5,4,3,51,54,56};
    RadixSort(a);   
}

public static void RadixSort(int[] a){
    int max = getMax(a);
    int n = 9;
    int[] output = new int[a.length+1];
    for (int exp = 1; max/exp > 0; exp *= 10){
        a = countSort(a, n, exp);
        System.out.println("==================================== Number" + exp);
        for(int i=0; i<a.length; i++)
        {
            System.out.println(a[i]);
        }
    }    
}

public static int getMax(int arr[])
    {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

public static int[] countSort(int[] a, int max, int exp){
       System.out.println("==================================== Array Recieved");
        for(int i=0; i<a.length; i++)
        {
            System.out.println(a[i]);
        }
      // Declare the count array
      int[] count =  new int[max+1];
      int[] output = new int[a.length+1];
      
      for(int i=0; i<a.length; i++){
          ++count[(a[i]/exp)%10];
      }
      
      for(int i=1; i<=max; i++){
          count[i] = count[i-1]+count[i];
      }
      
      // We fill this other way around because count sort assign duplicates from highest index to lowest
      // but in radix sort we are doing this by digit number
      // so for count sort 23 and 24 is equivalent at 2nd digit as both are 2
      // And count sort will assign 23 at 6 and 24 at 5th if we process the input array from beginning.
      for(int i=a.length-1; i>=0; i--){
          output[count[(a[i]/exp)%10]] = a[i];
          --count[((a[i]/exp)%10)];
      }
      
      return output;
    }

}