public class UniqueCharacterString2 {
    public static void main(String[] args){
        System.out.println(checkUnique("heeytr"));
    }
    
    public static boolean checkUnique(String s){
        int checked = 0;
        for(int i=0; i<s.length();i++){
            int val = s.charAt(i);
            if(((checked) & (1<<val)) > 0)
            return false;
            checked = checked | 1<<val;
        }
        return true;
    }
}