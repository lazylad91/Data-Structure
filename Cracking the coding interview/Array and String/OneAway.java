/* Write a program to see 2 strings are one edit away */

public class OneAway {
    public static void main(String[] args){
        System.out.println(oneEdit("juman","kuman"));
        System.out.println(oneEdit("juman","klman"));
        System.out.println(oneEdit("juman","jumana"));
    }
    
    public static boolean oneEdit(String first,String second){
        if(Math.abs(first.length()-second.length())>1)
            return false;
        if(first.length()== second.length())
            return oneEditReplace(first,second);
        if(first.length()>second.length())
            return oneEditInsert(first,second);
        else{
            return oneEditInsert(second,first);
        }
    }
    
    public static boolean oneEditInsert(String long1, String short1){
        int index1=0;
        int index2=0;
        while(index1<long1.length() && index2<short1.length()){
            if(long1.charAt(index1)!=short1.charAt(index2)){
                if(index1!=index2)   // For the first time, index will be same. Next time it will be diff so return false
                    return false;
                index1++;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }
    
    public static boolean oneEditReplace(String f,String s){
        boolean foundDiff = false;
        for(int i=0; i<f.length(); i++)
        {
            if(f.charAt(i)!= s.charAt(i)){
                if(foundDiff)
                return false;
                
                foundDiff=true;
            }
        }
        return true;
    }
}