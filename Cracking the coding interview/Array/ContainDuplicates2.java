/**
 * Given an array of integers and an integer k, find out whether 
 * there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the absolute difference between i and j is at most k.
 *
 */
 
 public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            // Absolute difference should be k, so element covered are k+1 for k=3 we have to check 4 consecutive element
            // we will start from 0 and till 3 we will just add it in set and check
            // now when we reach at 4th index before adding it we should remove 0th index
            // when we reach at 5th we should remove number at 1st index too
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
            return false;
        }
    }
}