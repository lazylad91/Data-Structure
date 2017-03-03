public class UniqueCharacterString {

    public static void main(String args[]){
        System.out.println(checkUnique("abcdreo"));
    }
    
    public static boolean checkUnique(String s){
        if(s.length()>128)  return false;  // Total number of characters in ASCII are 128, if more then 128 then duplicates
        
        boolean[] checkVector = new boolean[128];
        for(int i=0; i<s.length(); i++){
            char val = s.charAt(i);
            if(checkVector[val])
             return false;
             checkVector[val]=true;
        }
        return true;
    }
}