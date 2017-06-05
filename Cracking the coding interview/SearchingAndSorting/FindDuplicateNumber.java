/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.*/

/**
 * Linkedlist cycle type
 * public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;
 
    do{
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while(slow != fast);
 
    int find = 0;
 
    while(find != slow){
        slow = nums[slow];
        find = nums[find];
    }
    return find;
}*/
public class Solution {
    public int findDuplicate(int[] nums) {
        // Count sort first1
        int[] count = new int[nums.length+1];
        int[] output = new int[nums.length+1];
        for(int num : nums){
            count[num]++;
        }
        
        for(int i=1; i<count.length; i++){
            count[i] = count[i] + count[i-1];
        }
        
        for(int i=0; i<nums.length; i++){
            output[count[nums[i]]--] = nums[i];
        }
        
        /*for(int num : output){
            System.out.println(num);
        }*/
        
        // Now do the binary search
        int low = 0;
        int high = output.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            //System.out.println(low);
            //System.out.println(high);
            //System.out.println("mid element is" + output[mid]);
            //System.out.println("mid is" + mid);
            if(output[mid] < mid){
                high = mid-1;
                //System.out.println("output[mid-1]" + output[mid-1]);
                if(output[mid]==mid-1 && mid-1 == output[mid-1]){
                    return output[mid];
                }
            }
            else{
                low = mid+1;
            }
        }
        return 0;
    }
}