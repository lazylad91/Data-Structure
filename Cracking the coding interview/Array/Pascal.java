/**Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?*/

public class Solution {
     public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex<0)
        return res;
        
        for(int i=0; i<rowIndex+1; i++){
            res.add(0,1);
            for(int k=1; k<res.size()-1; k++){
                res.set(k,res.get(k)+res.get(k+1));
            }
        }
        
        return res;
    }
}