/**Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = 0;
        int count  = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
            if(maxcount<count)
                maxcount = count;
            }
            else{
                count=0;
            }
        }
        return maxcount;
    }
}

//better solution
 public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 