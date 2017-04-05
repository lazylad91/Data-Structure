/**Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
    /*
     * 
     *  `public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        int realsum = ((nums.length)*(nums.length+1))/2;
        
        return realsum-sum;
    }*/
*/

public class Solution {
    public int missingNumber(int[] nums){
        int x1 = nums.length; // for the last number
        for(int i = 0; i<nums.length; i++){
            x1 = x1^i;
            x1 = x1^nums[i];
        }
        
        return x1;
    }
}
