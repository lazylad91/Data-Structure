/* Nothing just mergin the 2 method, doing it little bit smartly*/
public class OneAway2 {
    public static void main(String[] args){
         System.out.println(oneEdit("juman","kuman"));
        System.out.println(oneEdit("juman","klman"));
        System.out.println(oneEdit("juman","jumana"));
    }
    
    public static boolean oneEdit(String first, String second){
        if(Math.abs(first.length()-second.length())>1)
            return false;
        
        String s1 = first.length()<second.length()? first : second;
        String s2 = first.length()<second.length()? second : first;
        
        int index1=0;
        int index2=0;
        boolean foundDiff = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(foundDiff)
                return false;
                foundDiff=true;
                if(s1.length()==s2.length())
                index1++;
                index2++;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }
}