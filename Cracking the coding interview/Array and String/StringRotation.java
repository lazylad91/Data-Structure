/* Check if string is rotation is of another string like happybirthday is rotation of birthdayhappy
Gist is its two string xy - x=happy y=birthday s2= yx it will be substring xyxy*/
public class StringRotation{
    public static void main(String[] args){
        System.out.println(checkSubstring("happybirthday","dayhappybirth"));
    }
    public static boolean checkSubstring(String s1, String s2){
        if(s1.length()!=s2.length() && s1.length()<=0)
            return false;
        else{
            s1=s1+s1;
            return s1.contains(s2);
        }
    }
}