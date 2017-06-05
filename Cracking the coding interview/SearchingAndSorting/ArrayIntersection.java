/**
 * Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        /**
         * Three methods below
         * 1) Take 2 set and put 1 array into set-1 and then for next array check if value exist in
         *    set-1 then only add in set-2
         * 2) Take 2 pointers and 1 set, sort the array and compare each element from both array
         *    if a[i] > a[j] then j++
         *    else if a[i] < a[j] then i++
         *    else add the value in set and i++ and j++
         * 3) Take 1 set and sort 1 array then iterate over another array and do binary search in sorted
         *    array if search return true then add result in set.
         **/
         
         
        /** // Implemening 2nd one
         
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         
         int i=0;
         int j=0;
         
         Set<Integer> res = new HashSet<Integer>();
         
         while(i < nums1.length && j < nums2.length){
             if(nums1[i] > nums2[j]){
                 j++;
             }
             else if(nums1[i] > nums2[j]){
                 i++;
             }
             else{
                res.add(nums1[i]);        
             }
         }
         int k=0;
         int[] result = new int[res.size()];
         for (Integer num : res) {
            result[k++] = num;
        }
        return result;*/
        
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            //Never use add here [] [1,1]
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int k=0;
         for (Integer num : set2) {
            result[k++] = num;
        }
        return result;
    }
    
}