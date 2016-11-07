import java.util.*;
public class CourseSchedule{
    public static void main(String args[]){
 
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
        HashSet<Integer> courseSet = new HashSet<>();
        courseSet.add(1);
        courseSet.add(2);
        courseSet.add(3);
        courseSet.add(4);
        courseSet.add(5);
        for(int i=0; i<prerequisites.length;i++){
            if(adjMap.containsKey(prerequisites[i][0]))
            {
                adjMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            else
            {
                adjMap.put(prerequisites[i][0],new ArrayList<Integer>());
                adjMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
            //adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
      
        HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
        HashMap<Integer,Boolean> onset = new HashMap<Integer,Boolean>();
        
        for(Integer i: courseSet)
          {
            visited.put(i,false);
            onset.put(i,false);
          }
          int current_label=numCourses;
         
      Stack<Integer> stk = new Stack<Integer>();  
      for(int i: courseSet){
          if(visited.get(i)==false)
             if(!dfs(numCourses,visited,onset,adjMap,current_label,i,stk)) return new int[0];
      }
       int[] res = new int[numCourses];
       int k = numCourses;
       while(!stk.empty()){
           res[--k]=stk.pop();
       }
       
       return res;
    }
    
    
    public static boolean dfs(int numCourses,HashMap<Integer,Boolean> visited,HashMap<Integer,Boolean> cycle,HashMap<Integer,List<Integer>> adjList,int current_label,int vertexNo,Stack<Integer> stk){
        visited.put(vertexNo,true);
        cycle.put(vertexNo,true);
        for(int i : adjList.get(vertexNo)){
            if(visited.get(i)==false){
              if(!dfs(numCourses,visited,cycle,adjList,current_label,i,stk)) return false;
              }else if(cycle.get(i)==true)
              return false;
        }
        stk.push(vertexNo);
        cycle.put(vertexNo,false);
        return true;
    }


}