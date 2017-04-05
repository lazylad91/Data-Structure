/**Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/


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