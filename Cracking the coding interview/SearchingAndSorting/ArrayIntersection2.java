/**Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Subscribe to see which companies asked this question.*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int nums : nums1){
            map.put(nums,map.getOrDefault(nums,0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int nums: nums2){
            if(map.containsKey(nums) && map.get(nums)>0){
                list.add(nums);
                map.put(nums,map.get(nums)-1);
            }
        }
        int[] res = new int[list.size()];
        int i=0;
        for(Integer num : list){
            res[i++] = num;
        }
        
        return res;
    }
}