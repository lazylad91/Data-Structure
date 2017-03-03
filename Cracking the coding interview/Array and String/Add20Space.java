// Best thing is to manipulate string from end to start
public class Add20Space {
    public static void main(String[] args){
       String s = "Mr John Smith";
        char[] charArr = new char[17];
        for(int i=0; i<s.length();i++)
            charArr[i]=s.charAt(i);
        System.out.println(removeSpace(charArr));
    }
    
    public static String removeSpace(char[] charArr){
        int Spaces =0;
        int len = 13;
        for(int i=0; i<len; i++){
            if(charArr[i]==' ')
            Spaces++;
        }
        int newLen = len+2*Spaces; // one space we are adding 2 more character
        for(int i=len-1; i>=0; i--){
            if(charArr[i]==' '){
                charArr[newLen-1] = '0';
                charArr[newLen-2] = '2';
                charArr[newLen-3] = '%';
                newLen=newLen-3;
            }
            else{
                charArr[newLen-1]=charArr[i];
                newLen=newLen-1;
            }
        }
        String newString1 = new String(charArr);
        return newString1;
    }
}