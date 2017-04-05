public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        while(numRows!=0){
            row.add(0,1);
            for(int i=1; i<row.size()-1; i++){
                row.set(i,row.get(i)+row.get(i+1));
            }
            res.add(new ArrayList<Integer>(row));
            numRows--;
        }
        
        return res;
    }
}