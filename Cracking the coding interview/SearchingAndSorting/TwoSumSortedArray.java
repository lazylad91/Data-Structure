public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] res = new int[2];
        while(low <= high){
            int v = numbers[low] + numbers[high];
            
            if(v == target){
                res[0] = low+1;
                res[1] = high+1;
                return res;
            }
            
            else if(v < target){
                low++;
            }
            else {
                high--;
            }
        }
        
        return res;
    }
}