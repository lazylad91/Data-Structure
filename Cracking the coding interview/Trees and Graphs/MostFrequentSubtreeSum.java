/** Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
For sake of saving time during contest, can't write so concise solution :)
Idea is post-order traverse the tree and get sum of every sub-tree, put sum to count mapping to a HashMap. Then generate result based on the HashMap

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxCount = 0;
    Map<Integer,Integer> sumMap;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> sumMap = new HashMap<Integer,Integer>();
        postOrderTraversal(root, sumMap);
        List<Integer> res = new ArrayList<Integer>();
        for(int key : sumMap.keySet()){
            if(sumMap.get(key) == maxCount)
                res.add(key);
        }
        
        return res.stream().mapToInt(i->i).toArray();
    }
    
    public int postOrderTraversal(TreeNode root, Map<Integer,Integer> sumMap){
        if(root==null)
        return 0;
        
        int leftSum = postOrderTraversal(root.left, sumMap);
        int rightSum = postOrderTraversal(root.right, sumMap);
        
       int currentSum = leftSum + rightSum + root.val;
        int count = sumMap.getOrDefault(currentSum, 0) + 1;
        sumMap.put(currentSum, count);
        
        if(count>maxCount)
        maxCount=count;
        
        return currentSum;
        
    }
}

