public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            /*System.out.println("mid"+mid);
            System.out.println("high"+high);
            System.out.println("low"+low);
            System.out.println("nums[mid]"+nums[mid]);*/
            if(nums[mid] == target){
                return true;
            }
            
            else if(nums[low] < nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // iMPORTANT 
            else if(nums[mid] < nums[low]){
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else{
                  //duplicates, we know nums[mid] != target, so nums[start] != target
            //based on current information, we can only move left pointer to skip one cell
            //thus in the worest case, we would have target: 2, and array like 11111111, then
            //the running time would be O(n)
                low++;
            }
        }
        return false;
    }
}