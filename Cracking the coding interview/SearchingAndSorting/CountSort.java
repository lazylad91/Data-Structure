public class CountSort {
    public static void main(String[] args){
        int[] a = {9,8,8,7,6,5,4,3,3,2,2,2,1,1};
        int[] result = sort(a,9);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    
    public static int[] sort(int[] a, int max){
      
      // Declare the count array
      int[] count =  new int[max+1];
      int[] output = new int[a.length+1];
      
      for(int i=0; i<a.length; i++){
          ++count[a[i]];
      }
      
      for(int i=1; i<=max; i++){
          count[i] = count[i-1]+count[i];
      }
      
      for(int i=0; i<a.length; i++){
          output[count[a[i]]] = a[i];
          --count[a[i]];
      }
      
      return output;
    }
}