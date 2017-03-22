/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * The map will save prefix sum till current node and no of occurences of that sum as there can be negative number
 * further and they will create the same sum in single path
 * Now if on the path  like 10 5 3 -2 -1 - we have to find 8 in between so
 * Map will have 
 *  10 1
 *  15 1
 *  18 1
 *  16 1
 *  15 1 ===>  will increase the count in map
 * 
 *  10 1  sum-target = 10-8 = 2 (doesnt exist in map at this point)
 *  15 2 = 15-8 =7 same
 *  18 1 = 18-8 = 10 exist in map ( so 1 sum exist)
 *  16 1  16-8 = 8 doesnt exist in map
 * so now when we backtrack we will start removing the number in the end from the map
 * 
 */
public class Solution {
   public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);  
    }
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.val;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0); 
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                                               + findPathSum(curr.right, sum, target, map);
       // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}